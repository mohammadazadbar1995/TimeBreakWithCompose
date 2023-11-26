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
import com.jetpack.designsystem.ThemePreviews

@Composable
fun CountdownRoute(
    viewModel: CountdownViewModel,

    ) {
    CountdownScreen()
}


@Composable
fun CountdownScreen(
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}

@ThemePreviews
@Composable
private fun CountdownScreenPreview() {
    Surface {
        CountdownScreen(

        )
    }
}