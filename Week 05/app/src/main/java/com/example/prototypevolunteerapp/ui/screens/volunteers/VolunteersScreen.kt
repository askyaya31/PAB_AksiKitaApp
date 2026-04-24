package com.example.prototypevolunteerapp.ui.screens.volunteers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.data.model.getDummyVolunteers
import com.example.prototypevolunteerapp.ui.components.AppFooter
import com.example.prototypevolunteerapp.ui.components.LoadingIndicator
import com.example.prototypevolunteerapp.ui.components.VolunteerCard
import kotlinx.coroutines.delay

private val ScreenBg = Color(0xFFEAEDE7)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteersScreen() {
    val backStack  = LocalBackStack.current
    val volunteers = remember { getDummyVolunteers() }

    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(800)
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Meet the Volunteers!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF1A1A1A)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { backStack.removeLastOrNull() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF1A1A1A)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = ScreenBg)
            )
        },
        containerColor = ScreenBg
    ) { innerPadding ->
        if (isLoading) {
            LoadingIndicator(modifier = Modifier.padding(innerPadding))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item { Spacer(modifier = Modifier.height(4.dp)) }
                items(volunteers.indices.toList()) { index ->
                    VolunteerCard(
                        volunteer = volunteers[index],
                        onViewProfile = {
                            backStack.add(
                                Routes.VolunteerDetailRoute(volunteerIndex = index)
                            )
                        }
                    )
                }
                item { AppFooter() }
            }
        }
    }
}
