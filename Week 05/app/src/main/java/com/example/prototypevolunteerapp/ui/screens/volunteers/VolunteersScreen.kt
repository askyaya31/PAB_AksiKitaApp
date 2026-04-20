package com.example.prototypevolunteerapp.ui.screens.volunteers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.data.model.getDummyVolunteers
import com.example.prototypevolunteerapp.ui.components.AppFooter
import com.example.prototypevolunteerapp.ui.components.LoadingIndicator
import com.example.prototypevolunteerapp.ui.components.VolunteerCard
import kotlinx.coroutines.delay

// Back Navigation buat tombol panah kiri di TopAppBar
// Passing Parameter tiap VolunteerCard mengirim data ke VolunteerDetailRoute
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteersScreen() {
    val backStack = LocalBackStack.current

    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(1000)
        isLoading = false
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meet The Volunteers") },
                navigationIcon = {
                    IconButton(onClick = { backStack.removeLastOrNull() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
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
        if (isLoading) {
            LoadingIndicator(modifier = Modifier.padding(innerPadding))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(getDummyVolunteers()) { volunteer ->
                    VolunteerCard(
                        volunteer = volunteer,
                        onViewProfile = {
                            // PAassing parameter ke VolunteerDetailRoute
                            backStack.add(
                                Routes.VolunteerDetailRoute(
                                    name     = volunteer.name,
                                    desc     = volunteer.description,
                                    imageRes = volunteer.imageRes,
                                    phone    = volunteer.phone ?: "",
                                    email    = volunteer.email ?: ""
                                )
                            )
                        }
                    )
                }
                item { AppFooter() }
            }
        }
    }
}