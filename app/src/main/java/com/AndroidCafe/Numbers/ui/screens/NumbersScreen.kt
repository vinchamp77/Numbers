package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.AndroidCafe.Numbers.ui.screens.Utils.genRandomNumbers
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

@Composable
fun NumbersScreen() {
    val randomNumbers = remember {
        val state = mutableStateListOf<Int>()
        state.addAll(genRandomNumbers())
        state
    }

    //toIndex is exclusive
    val numbers = randomNumbers.subList(fromIndex = 0, toIndex = 25)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UpperUI(
            modifier = Modifier
                .weight(0.4f),
            onRestartClick = {
                randomNumbers.clear()
                randomNumbers.addAll(genRandomNumbers())
            }
        )
        LowerUI(
            modifier = Modifier.weight(0.6f),
            data = numbers,
            onClick = { index ->

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

