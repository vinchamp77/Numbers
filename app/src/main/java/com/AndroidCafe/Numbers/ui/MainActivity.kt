package com.AndroidCafe.Numbers.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.AndroidCafe.Numbers.ui.screens.MainScreen
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumbersTheme(useSystemUIController = true) {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumbersTheme(useSystemUIController = false) {
        MainScreen()
    }
}