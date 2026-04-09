package com.example.prototypevolunteerapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale

class DetailProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val image = intent.getIntExtra("image", android.R.drawable.ic_menu_gallery)
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")

        setContent {
            MaterialTheme {
                DetailProfileScreen(name, desc, image, phone, email)
            }
        }
    }
}

@Composable
fun DetailProfileScreen(
    name: String?,
    desc: String?,
    image: Int,
    phone: String?,
    email: String?
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // biar bisa scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape) //  profil bulat
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(name ?: "", style = MaterialTheme.typography.headlineSmall)
        Text(desc ?: "")
        Spacer(modifier = Modifier.height(16.dp))

        //implicit intent : button share
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, name)
            }
            context.startActivity(Intent.createChooser(intent, "Share via"))
        }) {
            Text("Share")
        }

        // implicit intent : button ke nomer wa
        if (!phone.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                val uri = "https://wa.me/$phone".toUri()
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }) {
                Text("Chat WhatsApp")
            }
        }

        // implicit intent : button ke email
        if (!email.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = "mailto:$email".toUri()
                }
                context.startActivity(intent)
            }) {
                Text("Kirim Email")
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        //footer
        Text(
            "AksiKita © 2026",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}