package com.jetpack.countdown

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.countdown.model.CountdownState
import com.jetpack.countdown.model.CounterState
import com.jetpack.countdown.model.SECOND
import com.jetpack.countdown.model.WORKING_DURATION
import com.jetpack.countdown.model.WorkingState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountdownViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {

    private val _countdownState = mutableStateOf(CountdownState())
    val countdownState: State<CountdownState> = _countdownState

    var timerJob: Job = Job()


    fun startCountdown() {

        _countdownState.value = _countdownState.value.copy(
            counterState = CounterState.PLAY
        )

        timerJob = viewModelScope.launch {
            while (true) {
                delay(SECOND)
                if (_countdownState.value.remainTime > 0) {
                    _countdownState.value = _countdownState.value.copy(
                        remainTime = _countdownState.value.remainTime - 1
                    )
                } else {
                    when (_countdownState.value.workingState) {
                        WorkingState.REST -> {
                            _countdownState.value = _countdownState.value.copy(
                                workingState = WorkingState.WORK,
                                remainTime = WORKING_DURATION
                            )
                        }

                        WorkingState.WORK -> {
                            resetCountdownState()
                            this.cancel()
                        }
                    }

                    PlayAlarmSound()
                }

            }
        }
    }

    private fun PlayAlarmSound() {
        val mediaPlayer =
            MediaPlayer.create(context, com.jetpack.designsystem.R.raw.alarm)
        mediaPlayer.start()
    }

    fun resetCountdown() {
        if (timerJob.isActive) {
            resetCountdownState()
            timerJob.cancel()
        }

    }

    private fun resetCountdownState() {
        _countdownState.value = CountdownState()
    }

}
