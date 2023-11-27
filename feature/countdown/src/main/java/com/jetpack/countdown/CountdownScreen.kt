package com.jetpack.countdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpack.countdown.component.Counter
import com.jetpack.countdown.component.CounterController
import com.jetpack.countdown.model.CountdownState
import com.jetpack.countdown.model.CounterState
import com.jetpack.designsystem.ThemePreviews
import com.jetpack.designsystem.theme.TimeBreakWithComposeTheme

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel,

    ) {
//    CountdownScreen("", "")
}


@Composable
fun CountdownScreen(
    counterState: CounterState,
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
            countState = counterState,
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
                counterState = CounterState.INITIAL,
                countdownState = CountdownState(),
                onRestClicked = { },
                onStartClicked = { })
        }
    }

}