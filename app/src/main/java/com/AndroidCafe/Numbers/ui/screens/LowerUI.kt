package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

@Composable
fun LowerUI(
    modifier: Modifier = Modifier,
    data: List<Number>,
    onNumberClick: (Int) -> Unit,
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
                        text = data[index].value.toString(),
                        onClick = { onNumberClick(index) }
                    )
                }
            }
        }
    }
}

@Composable
private fun NumberButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
        ,
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    NumbersTheme {

        val viewModel = NumbersViewModel()

        LowerUI(
            data = viewModel.displayNumbers,
            onNumberClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberButtonPreview(){
    NumbersTheme {
        NumberButton(
            text = "88",
            onClick = {}
        )
    }
}
