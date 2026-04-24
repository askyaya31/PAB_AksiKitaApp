package com.example.prototypevolunteerapp.ui.screens.dashboard

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.core.LocalBackStack
import com.example.prototypevolunteerapp.core.Routes
import com.example.prototypevolunteerapp.core.UserSession
import com.example.prototypevolunteerapp.data.model.getDummyActivities
import com.example.prototypevolunteerapp.ui.components.AppFooter

@Composable
fun HomeScreen() {
    val backStack = LocalBackStack.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()
        Column(modifier = Modifier.padding(16.dp)) {
            NearbyActivityCard()
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(19.dp))
            RecommendationSection()
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(24.dp))
            FeatureGrid(
                onActivitiesClick    = { backStack.add(Routes.ActivitiesRoute) },
                onVolunteersClick    = { backStack.add(Routes.VolunteersRoute) },
                onHistoryClick       = { backStack.add(Routes.ActivityHistoryRoute) },
                onNotificationsClick = { backStack.add(Routes.NotificationsRoute) }
            )
        }
        AppFooter()
    }
}

@Composable
fun HeaderSection() {
    val userName = UserSession.currentUser?.name
        ?.split(" ")
        ?.firstOrNull()
        ?: "Volunteer"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(listOf(Color(0xFF3A4A3D), Color(0xFF8FB697)))
            )
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    //nama asli dari UserSession
                    text = "Hello, $userName!",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search social activity") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun NearbyActivityCard() {
    val context = LocalContext.current
    Text("Find Impact Near You!", color = Color.Black, fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(12.dp))
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.social_activity2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(0.6f)))
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://linktr.ee/AbdinationIndonesiaMengabdi3")
                    )
                    context.startActivity(intent)
                }) {
                    Text("Join Now")
                }
            }
        }
    }
}

@Composable
fun RecommendationSection() {
    Text("Recommendation Activity", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        getDummyActivities().take(5).forEach {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(140.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFCA64))
            ) {
                Box {
                    Image(
                        painter = painterResource(it.imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun FeatureGrid(
    onActivitiesClick: () -> Unit,
    onVolunteersClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureCard(Modifier.weight(1f), "Get Activities", Icons.Default.VolunteerActivism, onActivitiesClick)
            FeatureCard(Modifier.weight(1f), "Our Volunteers", Icons.Default.Group, onVolunteersClick)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FeatureCard(Modifier.weight(1f), "History", Icons.Default.History, onHistoryClick)
            FeatureCard(Modifier.weight(1f), "Notifications", Icons.Default.Notifications, onNotificationsClick)
        }
    }
}

@Composable
fun FeatureCard(
    modifier: Modifier,
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF92BA9A)),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, null, tint = Color(0XFF1A2421))
            Spacer(modifier = Modifier.height(8.dp))
            Text(title)
        }
    }
}
