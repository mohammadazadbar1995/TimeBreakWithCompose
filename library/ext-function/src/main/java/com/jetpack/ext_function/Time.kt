package com.jetpack.ext_function

val Int.minutes: Int
    get() = this / 60

val Int.seconds: Int
    get() = this % 60

fun String.toTwoDigitFormat():String =
    if (this.length == 1) {
        "0$this"
    }
    else this