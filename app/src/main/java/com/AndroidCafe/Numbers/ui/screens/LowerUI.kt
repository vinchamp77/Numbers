package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LowerUI(
    modifier: Modifier = Modifier,
    data: List<Int>,
    onClick: (Int) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        for(row in 0..4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically,
            ) {
                for(col in 0..4) {
                    val index = row * 5 + col
                    NumberButton(
                        //modifier = modifier.fillMaxSize(),
                        text = data[index].toString(),
                        onClick = { onClick(index) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){

    LowerUI(
        data = Utils.genRandomNumbers(start = 1, end = 25),
        onClick = {}
    )
}
