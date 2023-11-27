package com.jetpack.countdown.model


data class CountdownState(
    val counterState: CounterState = CounterState.INITIAL,
    val workingState: WorkingState = WorkingState.WORk,
    val remainTime: Int = WORKING_DURATION,
)