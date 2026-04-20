package com.example.prototypevolunteerapp.ui.screens.activities

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.ui.components.AppFooter

// Parameter kaya title, desc diterima langsung dari entryProvider di ComposeApp
//Back Navigation : tombol panah kiri pake backStack.removeLastOrNull()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityDetailScreen(
    title: String?,
    location: String?,
    desc: String?,
    imageRes: Int,
    instagram: String?,
    link: String?
) {
    val backStack = LocalBackStack.current
    val context   = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Activity") },
                // Back Navigation
                navigationIcon = {
                    IconButton(onClick = { backStack.removeLastOrNull() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
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
                painter = painterResource(imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = title ?: "Activity",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = location ?: "",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = desc ?: "Empty Description",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            //Tombol Share (pake Intent, bukan navigasi antar screen)
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, title)
                    }
                    context.startActivity(Intent.createChooser(intent, "Bagikan via"))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Share")
            }
            //pake intent
            if (!instagram.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW, instagram.toUri())
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("View Instagram")
                }
            }
            //pake intent
            if (!link.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW, link.toUri())
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Join Now")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            AppFooter()
        }
    }
}
