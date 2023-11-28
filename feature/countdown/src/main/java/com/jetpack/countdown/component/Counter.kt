package com.jetpack.countdown.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.jetpack.countdown.model.CountdownState
import com.jetpack.designsystem.ThemePreviews
import com.jetpack.designsystem.theme.TimeBreakWithComposeTheme
import com.jetpack.ext_function.minutes
import com.jetpack.ext_function.seconds
import com.jetpack.ext_function.toTwoDigitFormat

@Composable
fun Counter(
    countdownState: CountdownState,
) {
    val minutes = countdownState.remainTime.minutes.toString().toTwoDigitFormat()

    val seconds = countdownState.remainTime.seconds.toString().toTwoDigitFormat()

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CounterText(text = minutes)
        Text(text = " : ")
        CounterText(text = seconds)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
private fun CounterPreview() {
    TimeBreakWithComposeTheme {
        Surface {
            Counter(countdownState = CountdownState())
        }
    }

}