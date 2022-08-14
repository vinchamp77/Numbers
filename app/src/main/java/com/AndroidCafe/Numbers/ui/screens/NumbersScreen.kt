package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

@Composable
fun NumbersScreen() {

    val viewModel:NumbersViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UpperUI(
            modifier = Modifier.weight(0.4f),
            onRestartClick = {
                viewModel.generateRandomNumbers()
            }
        )
        LowerUI(
            modifier = Modifier.weight(0.6f),
            data = viewModel.displayNumbers,
            onNumberClick = { index ->

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NumbersScreenPreview() {
    NumbersTheme() {
        NumbersScreen()
    }
}

