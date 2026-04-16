package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototypevolunteerapp.ui.screens.volunteers.VolunteersScreen
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

class VolunteersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AksiKitaTheme {
                VolunteersScreen()
            }
        }
    }
}