package com.example.prototypevolunteerapp.ui.screens.history

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
fun ActivityHistoryScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activity History") },
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
                    text = "Your Contributions",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Dummy riwayat
            items(listOf(
                "Little Chef Day - Wizzmie Solo",
                "From Heart to Paper - Jakarta Timur",
                "Aksi Bersih Pantai Parangtritis"
            )) { activity ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp) ,
                    colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFA2D365)
                            )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = activity, style = MaterialTheme.typography.titleSmall)
                        Text(
                            text = "12 April 2026 • Sudah selesai",
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