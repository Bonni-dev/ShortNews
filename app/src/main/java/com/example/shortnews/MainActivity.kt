package com.example.shortnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.shortnews.ui.theme.ShortNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShortNewsTheme {

            }
        }
    }
}

@Composable
fun ShortNewsEntryPoint() {

}
