package com.example.prototypevolunteerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.core.UserSession


@Composable
fun LoginScreen() {
    val backStack = LocalBackStack.current
    var email           by remember { mutableStateOf("") }
    var password        by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var loginError      by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(DarkGreen, MediumGreen, LightGreen)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Login Account",
                color = White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it; loginError = "" },
                placeholder = { Text("Gmail", color = HintColor) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedBorderColor = White.copy(alpha = 0.6f),
                    unfocusedBorderColor = White.copy(alpha = 0.3f),
                    focusedContainerColor = InputBg,
                    unfocusedContainerColor = InputBg,
                    cursorColor = White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it; loginError = "" },
                placeholder = { Text("Password", color = HintColor) },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle password",
                            tint = HintColor
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = White,
                    unfocusedTextColor = White,
                    focusedBorderColor = White.copy(alpha = 0.6f),
                    unfocusedBorderColor = White.copy(alpha = 0.3f),
                    focusedContainerColor = InputBg,
                    unfocusedContainerColor = InputBg,
                    cursorColor = White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )
            if (loginError.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = loginError,
                    color = Color(0xFFFFCDD2),
                    fontSize = 13.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Text(
                    text = "Forgot Password?",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    modifier = Modifier.clickable { /* mockup */ }
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = {
                    val success = UserSession.login(email.trim(), password.trim())
                    if (success) {
                        backStack.add(Routes.HomeRoute)
                    } else {
                        loginError = "Email atau password salah"
                    }
                },
                // CONDITIONAL NAVIGATION: tombol aktif hanya jika keduanya tidak kosong
                enabled = email.isNotBlank() && password.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A1A1A),
                    disabledContainerColor = Color(0xFF1A1A1A).copy(alpha = 0.4f)
                ),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .width(145.dp)
                    .height(52.dp)
            ) {
                Text(
                    text = "Login",
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = White.copy(alpha = 0.4f), thickness = 1.dp)
                Text("  Or Login With  ", color = White, fontSize = 13.sp)
                HorizontalDivider(modifier = Modifier.weight(1f), color = White.copy(alpha = 0.4f), thickness = 1.dp)
            }
            Spacer(modifier = Modifier.height(28.dp))
            Surface(
                onClick = { /* masih mockup */ },
                shape = RoundedCornerShape(50.dp),
                color = White,
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth().height(56.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.gugel_icon),
                        contentDescription = "Google Icon",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(color = Color(0xFF3C3C3C), fontWeight = FontWeight.Medium)) {
                                append("Continue with ")
                            }
                            withStyle(SpanStyle(color = Color(0xFF4285F4), fontWeight = FontWeight.SemiBold)) {
                                append("Google")
                            }
                        },
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                Text("Belum memiliki akun? ", color = White, fontSize = 14.sp)
                Text(
                    text = "Register",
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { /* mockup register */ }
                )
            }
            Spacer(modifier = Modifier.height(27.dp))
        }
    }
}

private val DarkGreen   = Color(0xFF121713)
private val MediumGreen = Color(0xFF5C7561)
private val LightGreen  = Color(0xFF92BA9A)
private val InputBg     = Color(0x33FFFFFF)
private val White       = Color.White
private val HintColor   = Color(0xAAFFFFFF)
