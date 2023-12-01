package com.jetpack.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jetpack.countdown.component.Counter
import com.jetpack.countdown.component.CounterController
import com.jetpack.countdown.model.CountdownState
import com.jetpack.designsystem.ThemePreviews
import com.jetpack.designsystem.theme.TimeBreakWithComposeTheme
import com.jetpack.ext_function.minutes
import com.jetpack.ext_function.seconds
import com.jetpack.ext_function.toTwoDigitFormat

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel = hiltViewModel(),
    onCounterUpdate: (String) -> Unit,
) {

    val state = viewModel.countdownState.value
    state.remainTime.apply {
        val minutes = minutes.toString().toTwoDigitFormat()
        val seconds = seconds.toString().toTwoDigitFormat()
        val notificationContent = "$minutes : $seconds"

        SideEffect {
            onCounterUpdate(notificationContent)

        }

    }



    CountdownScreen(
        countdownState = state,
        onRestClicked = { viewModel.resetCountdown() },
        onStartClicked = { viewModel.startCountdown() },
    )
}


@Composable
fun CountdownScreen(
    countdownState: CountdownState,
    onRestClicked: () -> Unit,
    onStartClicked: () -> Unit,

    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //TODO:
        Counter(countdownState = countdownState)
        Spacer(modifier = Modifier.height(16.dp))
        CounterController(
            countState = countdownState.counterState,
            onRestClicked = { onRestClicked() },
            onStartClicked = { onStartClicked() }
        )
    }
}

@ThemePreviews
@Composable
private fun CountdownScreenPreview() {
    TimeBreakWithComposeTheme {
        Surface {
            CountdownScreen(
                countdownState = CountdownState(),
                onRestClicked = { },
                onStartClicked = { })
        }
    }

}