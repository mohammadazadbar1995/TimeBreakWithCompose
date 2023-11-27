package com.jetpack.ext_function

val Int.minutes: Int
    get() = this / 60

val Int.seconds: Int
    get() = this % 60