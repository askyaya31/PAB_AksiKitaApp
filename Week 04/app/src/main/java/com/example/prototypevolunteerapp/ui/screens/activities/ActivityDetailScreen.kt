package com.example.prototypevolunteerapp.ui.screens.activities

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.prototypevolunteerapp.ui.components.AppFooter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityDetailScreen(
    title: String?,
    location: String?,
    desc: String?,
    image: Int,
    instagram: String?,
    link: String?
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Kegiatan") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(title ?: "", style = MaterialTheme.typography.headlineMedium)
            Text(location ?: "", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))
            Text(desc ?: "")

            Spacer(modifier = Modifier.height(24.dp))

            // Share Button
            Button(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, title)
                }
                context.startActivity(Intent.createChooser(intent, "Share via"))
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Share Activity")
            }

            // Instagram Button
            if (!instagram.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, instagram.toUri())
                    context.startActivity(intent)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text("View Instagram")
                }
            }

            // Daftar Button
            if (!link.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, link.toUri())
                    context.startActivity(intent)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text("Join Now")
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            AppFooter()
        }
    }
}