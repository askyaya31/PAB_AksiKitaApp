package com.example.prototypevolunteerapp

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.ui.screens.dashboard.DashboardScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AksiKitaApp() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AksiKita") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        DashboardScreen(
            modifier = Modifier.padding(innerPadding),
            onFindImpactClick = {
                val intent = Intent(context, ActivitiesActivity::class.java)
                context.startActivity(intent)
            },
            onMeetVolunteersClick = {
                val intent = Intent(context, VolunteersActivity::class.java)
                context.startActivity(intent)
            }
        )
    }
}