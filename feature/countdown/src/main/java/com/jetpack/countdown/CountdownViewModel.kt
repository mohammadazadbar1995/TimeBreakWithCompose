package com.jetpack.countdown

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jetpack.countdown.model.CountdownState
import com.jetpack.countdown.model.CounterState
import com.jetpack.countdown.model.WorkingState

class CountdownViewModel : ViewModel() {

    private val _countdownState = mutableStateOf(CountdownState())
    val countdownState: State<CountdownState> = _countdownState


}
