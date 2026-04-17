package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototypevolunteerapp.ui.screens.notifications.NotificationsScreen
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

class NotificationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AksiKitaTheme {
                NotificationsScreen()
            }
        }
    }
}