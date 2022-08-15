package com.AndroidCafe.Numbers.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

private val Context.dataStore by preferencesDataStore(
    name = "settings",
)

@Composable
fun MainScreen() {
    val viewModel:MainViewModel = viewModel(
        factory = MainViewModelFactory(LocalContext.current.dataStore)
    )

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
            bestTime = viewModel.bestTime,
            currentTime = viewModel.currentTime,
            onRestartClick = {
                viewModel.onRestartClick()
            },
        )
        LowerUI(
            modifier = Modifier.weight(0.6f),
            data = viewModel.displayNumbers,
            onNumberClick = { index ->
                viewModel.onNumberClick(index)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NumbersScreenPreview() {
    NumbersTheme() {
        MainScreen()
    }
}

