package com.jetpack.countdown.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jetpack.countdown.model.CounterState
import com.jetpack.designsystem.ThemePreviews
import com.jetpack.designsystem.theme.TimeBreakWithComposeTheme

@Composable
fun CounterController(
    countState: CounterState,
    onRestClicked: () -> Unit,
    onStartClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 0.3F),
            onClick = {
                when (countState) {
                    CounterState.INITIAL -> onStartClicked()
                    CounterState.PLAY -> onRestClicked()
                    CounterState.PAUSE -> onRestClicked()
                }

            }) {
            Icon(
                imageVector = when (countState) {
                    CounterState.INITIAL -> Icons.Rounded.PlayArrow
                    CounterState.PLAY -> Icons.Rounded.PlayArrow
                    CounterState.PAUSE -> Icons.Rounded.PlayArrow
                },
                contentDescription = null
            )
        }
    }
}


@ThemePreviews
@Composable
fun CounterControllerPreview() {
    TimeBreakWithComposeTheme {
        Surface {
            CounterController(
                countState = CounterState.INITIAL,
                onRestClicked = {},
                onStartClicked = {},
            )
        }
    }
}