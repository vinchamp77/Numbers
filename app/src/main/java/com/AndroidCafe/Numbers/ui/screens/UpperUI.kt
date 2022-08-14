package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme
import org.w3c.dom.Text

@Composable
fun UpperUI(
    modifier: Modifier = Modifier,
    currentTime: String,
    onRestartClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "YOUR BEST TIME: ?")
        Text(text = currentTime)
        Button(onClick = onRestartClick) {
            Text(text = "RESTART")
        }
        Text(
            text ="Touch from 1 to 50 as fast as you can!",
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    NumbersTheme {
        UpperUI(
            currentTime = "0.0",
            onRestartClick = {}
        )
    }
}
