package com.AndroidCafe.Numbers.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.AndroidCafe.Numbers.ui.screens.NumbersScreen
import com.AndroidCafe.Numbers.ui.theme.NumbersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(useSystemUIController: Boolean = true) {
    NumbersTheme(useSystemUIController = useSystemUIController) {
        NumbersScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen(useSystemUIController = false)
}