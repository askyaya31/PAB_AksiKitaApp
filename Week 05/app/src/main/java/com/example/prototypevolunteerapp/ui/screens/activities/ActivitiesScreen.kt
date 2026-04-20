package com.example.prototypevolunteerapp.ui.screens.activities

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.data.model.getDummyActivities
import com.example.prototypevolunteerapp.ui.components.ActivityCard
import com.example.prototypevolunteerapp.ui.components.AppFooter
import com.example.prototypevolunteerapp.ui.components.LoadingIndicator
import kotlinx.coroutines.delay

// Back Navigation: tombol panah kiri di TopAppBar nah itu pake backStack.removeLastOrNull()
// Passing Parameter: tiap ActivityCard meneruskan data ke ActivityDetailRoute
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen() {
    val backStack = LocalBackStack.current
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(800)
        isLoading = false
    }

    val filteredActivities = remember(searchQuery) {
        if (searchQuery.isBlank()) getDummyActivities()
        else getDummyActivities().filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
                    it.location.contains(searchQuery, ignoreCase = true)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Social Activity") },
                // Ini back navigationnya
                navigationIcon = {
                    IconButton(onClick = {backStack.removeLastOrNull() }) {
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
        Column(modifier = Modifier.padding(innerPadding)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search social activity or location") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                singleLine = true
            )

            if (isLoading) {
                LoadingIndicator()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (filteredActivities.isEmpty()) {
                        item {
                            Text(
                                text = "Can't find social activity :(",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(32.dp),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    } else {
                        items(filteredActivities) { activity ->
                            // ActivityCard menerima lambda onViewDetail jadi ga perlu Intent
                            ActivityCard(
                                activity = activity,
                                onViewDetail = {
                                    // Passing Param : kirim semua data activity ke route detail
                                    backStack.add(
                                        Routes.ActivityDetailRoute(
                                            title     = activity.title,
                                            location  = activity.location,
                                            desc      = activity.description,
                                            imageRes  = activity.imageRes,
                                            instagram = activity.instagram ?: "",
                                            link      = activity.link ?: ""
                                        )
                                    )
                                }
                            )
                        }
                    }
                    item { AppFooter() }
                }
            }
        }
    }
}
