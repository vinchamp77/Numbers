package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

@Composable
fun LowerUI(
    modifier: Modifier = Modifier,
    numbers: List<Number>,
    onNumberClick: (Int) -> Unit,
    showResult: Boolean
) {
    if (!showResult) {
        NumberButtons(modifier, numbers, onNumberClick)
    } else {
        ResultUI(modifier)
    }
}

@Composable
private fun NumberButtons(
    modifier: Modifier,
    numbers: List<Number>,
    onNumberClick: (Int) -> Unit,
){
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
                    val number = numbers[index]
                    NumberButton(
                        text = number.value.toString(),
                        onClick = { onNumberClick(index) },
                        hidden = number.hidden,
                    )
                }
            }
        }
    }
}

@Composable
private fun NumberButton(
    text: String,
    onClick: () -> Unit,
    hidden: Boolean = false,
) {
    val buttonColors =
        if (hidden) {
            ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent)
        } else {
            ButtonDefaults.buttonColors()
        }

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(65.dp)
            .height(65.dp),
        colors = buttonColors,
    ) {
        Text(text = text)
    }
}

@Composable
private fun ResultUI(modifier: Modifier){
    val backgroundColor = MaterialTheme.colors.primary
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(15.dp)
        ,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        ResultText("10 - 19 sec: Impossible!")
        ResultText("20 - 29 sec: Liar!")
        ResultText("30 - 39 sec: You're special!")
        ResultText("40 - 59 sec: Expert")
        ResultText("60 - 79 sec: Normal")
        ResultText("80 - 89 sec: You're getting old!")
        ResultText("More than 90 sec: You're old!")

    }
}

@Composable
private fun ResultText(text:String) {
    val textColor = contentColorFor(MaterialTheme.colors.primary)
    Text(text = text, fontSize = 20.sp, color = textColor)
}

@Preview(showBackground = true)
@Composable
private fun NumbersPreview(){
    NumbersTheme {

        val viewModel = MainViewModel(dataStore = LocalContext.current.dataStore)

        LowerUI(
            numbers = viewModel.displayNumbers,
            onNumberClick = {},
            showResult = false,
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

@Preview(showBackground = true)
@Composable
private fun ResultPreview(){
    NumbersTheme {

        val viewModel = MainViewModel(dataStore = LocalContext.current.dataStore)

        LowerUI(
            numbers = viewModel.displayNumbers,
            onNumberClick = {},
            showResult = true,
        )
    }
}