package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.ui.screens.volunteers.VolunteerDetailScreen
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

class VolunteerDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val image = intent.getIntExtra("image", R.drawable.volunteer1)
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        setContent {
            AksiKitaTheme {
                VolunteerDetailScreen(
                    name = name,
                    desc = desc,
                    image = image,
                    phone = phone,
                    email = email
                )
            }
        }
    }
}