package com.jetpack.countdown.model


data class CountdownState(
    val counterState: CounterState = CounterState.INITIAL,
    val workingState: WorkingState = WorkingState.WORK,
    val remainTime: Long = WORKING_DURATION,
)