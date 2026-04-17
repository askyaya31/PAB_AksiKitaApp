package com.example.prototypevolunteerapp.ui.screens.notifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.ui.components.AppFooter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notification") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "New Activities",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 11.dp)
                )
            }

            // Dummy notifikasi
            items(listOf(
                "Pendaftaran Little Chef Day berhasil!",
                "Abdination Labuan Bajo - Gelombang 2 dibuka",
                "Reminder: Kegiatan Volunteer besok pukul 10.00 WIB"
            )) { notification ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFA2D365)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = notification,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Baru • 2 jam yang lalu",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFFB27704)
                        )
                    }
                }
            }

            item {
                AppFooter()
            }
        }
    }
}