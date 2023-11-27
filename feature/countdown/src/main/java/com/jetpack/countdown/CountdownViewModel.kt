package com.jetpack.countdown

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountdownViewModel : ViewModel() {

    private val _countdownState = mutableStateOf(CountdownState())
    val countdownState: State<CountdownState> = _countdownState


}

data class CountdownState(
    val counterState: CounterState = CounterState.INITIAL,
    val workingState: WorkingState = WorkingState.WORk,
    val remainTime: Int = REST_DURATION,
)

enum class CounterState {
    INITIAL, PLAY, PAUSE
}

enum class WorkingState {
    REST, WORk
}

const val REST_DURATION = 20
const val WORKING_DURATION = 20 * 60