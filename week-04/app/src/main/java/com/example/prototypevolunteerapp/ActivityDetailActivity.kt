package com.example.prototypevolunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.ui.screens.activities.ActivityDetailScreen
import com.example.prototypevolunteerapp.ui.theme.AksiKitaTheme

class ActivityDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title")
        val location = intent.getStringExtra("location")
        val desc = intent.getStringExtra("desc")
        val image = intent.getIntExtra("image", R.drawable.social_activity1)
        val instagram = intent.getStringExtra("instagram")
        val link = intent.getStringExtra("link")

        setContent {
            AksiKitaTheme {
                ActivityDetailScreen(
                    title = title,
                    location = location,
                    desc = desc,
                    image = image,
                    instagram = instagram,
                    link = link
                )
            }
        }
    }
}