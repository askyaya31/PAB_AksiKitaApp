package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.prototypevolunteerapp.core.ComposeApp

// Semua navigasi ditangani oleh Navigation 3 di dalam ComposeAp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeApp()
        }
    }
}
