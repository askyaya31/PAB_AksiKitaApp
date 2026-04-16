package com.example.prototypevolunteerapp.ui.screens.dashboard

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.R
import com.example.prototypevolunteerapp.ui.components.AppFooter

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    onFindImpactClick: () -> Unit,
    onMeetVolunteersClick: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "AksiKita",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Connecting People, Creating Impact",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "AksiKita Logo",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1.1f)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onFindImpactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Find Your Impact!", style = MaterialTheme.typography.titleMedium)
            }

            OutlinedButton(
                onClick = onMeetVolunteersClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Meet the Volunteers", style = MaterialTheme.typography.titleMedium)
            }
        }
        AppFooter()
    }
}