package com.example.mylagoscity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mylagoscity.ui.theme.MyLagosCityTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLagosCityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val windowSize: WindowSizeClass = calculateWindowSizeClass(activity = this)
                    MyCityApp(
                        windowSize = windowSize.widthSizeClass,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview(widthDp = 1000)
@Composable
fun GreetingPreview() {
    MyLagosCityTheme(darkTheme = false) {
        MyCityApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

@Preview( showBackground = true)
@Composable
fun AppPreview() {
    MyLagosCityTheme(darkTheme = false) {
        MyCityApp(windowSize = WindowWidthSizeClass.Compact)
    }
}