package com.example.prototypevolunteerapp

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.core.net.toUri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title")
        val location = intent.getStringExtra("location")
        val desc = intent.getStringExtra("desc")
        val image = intent.getIntExtra("image", android.R.drawable.ic_menu_gallery)
        val instagram = intent.getStringExtra("instagram")
        val link = intent.getStringExtra("link")

        setContent {
            MaterialTheme {
                DetailScreen(title, location, desc, image, instagram, link)
            }
        }
    }
}

@Composable
fun DetailScreen(
    title: String?,
    location: String?,
    desc: String?,
    image: Int,
    instagram: String?,
    link: String?
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(title ?: "", style = MaterialTheme.typography.headlineSmall)
        Text(location ?: "")
        Spacer(modifier = Modifier.height(8.dp))
        Text(desc ?: "")
        Spacer(modifier = Modifier.height(16.dp))

        // implicit intent : button share
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, title)
                }
                context.startActivity(Intent.createChooser(intent, "Share via"))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Share")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // implicit intent : button ke link ig
        if (!instagram.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, instagram.toUri())
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Lihat Instagram")
            }
        }

        // implicit intent : button ke link pendaftaran
        if (!link.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, link.toUri())
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Daftar Sekarang")
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