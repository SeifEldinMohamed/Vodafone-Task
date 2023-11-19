package com.example.vodafonetask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.vodafonetask.ui.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VodafoneTaskTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.inverseOnSurface) {
                    AppNavHost()
                }
            }
        }
    }
}
