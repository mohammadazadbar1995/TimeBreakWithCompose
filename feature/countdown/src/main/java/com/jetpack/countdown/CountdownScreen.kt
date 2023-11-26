package com.jetpack.countdown

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.countdown.component.Counter
import com.jetpack.designsystem.ThemePreviews
import com.jetpack.designsystem.theme.TimeBreakWithComposeTheme

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel,

    ) {
    CountdownScreen("", "")
}


@Composable
fun CountdownScreen(
    minutes: String,
    seconds: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TODO:
        Counter(minutes = minutes, seconds = seconds)
    }
}

@ThemePreviews
@Composable
private fun CountdownScreenPreview() {
    TimeBreakWithComposeTheme {
        Surface {
            CountdownScreen(
                minutes = "19",
                seconds = "59"
            )
        }
    }

}