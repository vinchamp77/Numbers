package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UpperUI(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("YOUR BEST TIME: ?")
        Text("0.0")
        Button(onClick = { /*TODO*/ }) {
            Text("RESTART")
        }
        Text("Touch from 1 to 50 as fast as you can!")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UpperUI()
}
