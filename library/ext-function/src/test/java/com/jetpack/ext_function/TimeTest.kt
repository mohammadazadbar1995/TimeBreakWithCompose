package com.jetpack.ext_function

import org.junit.Assert
import org.junit.Test

class TimeTest {

    @Test
    fun timeToMinutes() {
        Assert.assertEquals(0L.minutes, 0)
        Assert.assertEquals(20L.minutes, 0)
        Assert.assertEquals(60L.minutes, 1)
        Assert.assertEquals(90L.minutes, 1)
        Assert.assertEquals(120L.minutes, 2)
        Assert.assertEquals(121L.minutes, 2)
    }

    @Test
    fun timeToSeconds() {
        Assert.assertEquals(0L.seconds, 0)
        Assert.assertEquals(20L.seconds, 20)
        Assert.assertEquals(60L.seconds, 0)
        Assert.assertEquals(90L.seconds, 30)
        Assert.assertEquals(120L.seconds, 0)
        Assert.assertEquals(121L.seconds, 1)
    }

    @Test
    fun timeToTwoDigitFormat() {
        Assert.assertEquals(0L.seconds.toString().toTwoDigitFormat(), "00")
        Assert.assertEquals(1L.seconds.toString().toTwoDigitFormat(), "01")
        Assert.assertEquals(10L.seconds.toString().toTwoDigitFormat(), "10")
        Assert.assertEquals(11L.seconds.toString().toTwoDigitFormat(), "11")
        Assert.assertEquals(100L.seconds.toString().toTwoDigitFormat(), "40")
        Assert.assertEquals(1200L.seconds.toString().toTwoDigitFormat(), "00")
        Assert.assertEquals(1200L.minutes.toString().toTwoDigitFormat(), "20")
    }
}