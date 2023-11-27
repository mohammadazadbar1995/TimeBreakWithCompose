package com.jetpack.ext_function

val Long.minutes: Long
    get() = this / 60

val Long.seconds: Long
    get() = this % 60

fun String.toTwoDigitFormat():String =
    if (this.length == 1) {
        "0$this"
    }
    else this