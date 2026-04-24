package com.example.prototypevolunteerapp.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.ui.components.AppFooter

// terdapat Conditional Navigation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen() {
    val backStack = LocalBackStack.current
    // State buat TextField nama (conditional navigation)
    var namaInput by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF3A4A3D), Color(0xFF8FB697))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            // Logo dan Judul
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Welcome",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "AksiKita Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .aspectRatio(1f)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "AksiKita",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Connecting People, Creating Impact",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )
            }

            // Input & Tombol
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //TextField nama dipakai untuk conditional navigation
                OutlinedTextField(
                    value = namaInput,
                    onValueChange = {
                        namaInput = it
                        if (it.isNotBlank()) showError = false
                    },
                    placeholder = { Text("Input your name") },
                    singleLine = true,
                    isError = showError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        errorContainerColor = Color(0xFFFFF0F0),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )
                if (showError) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Name cannot be empty!",
                        color = Color(0xFFFFCDD2),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Conditional navigation
                //tombol hanya berpindah layar jika namaInput tidak kosong
                Button(
                    onClick = {
                        if (namaInput.isBlank()) {
                            showError = true
                        } else {
                            backStack.add(Routes.LoginRoute)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xEEF6F9EF)
                    )
                ) {
                    Text(
                        text = "Start Contributing",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                AppFooter()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
