package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototypevolunteerapp.ui.screens.activities.ActivitiesScreen   // ← Perbaikan di sini
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

class ActivitiesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AksiKitaTheme {
                ActivitiesScreen()
            }
        }
    }
}