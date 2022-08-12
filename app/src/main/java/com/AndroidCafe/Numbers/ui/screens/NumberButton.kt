package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberButton(
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
        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    NumberButton(
        text = "88",
        onClick = {}
    )
}
