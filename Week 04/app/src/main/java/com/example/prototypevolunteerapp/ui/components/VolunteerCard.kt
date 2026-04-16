package com.example.prototypevolunteerapp.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.VolunteerDetailActivity
import com.example.prototypevolunteerapp.data.model.Volunteer

@Composable
fun VolunteerCard(volunteer: Volunteer) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = volunteer.imageRes),
                contentDescription = volunteer.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = volunteer.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = volunteer.education,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = volunteer.description.lines().firstOrNull() ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    val intent = Intent(context, VolunteerDetailActivity::class.java).apply {
                        putExtra("name", volunteer.name)
                        putExtra("desc", volunteer.description)
                        putExtra("image", volunteer.imageRes)
                        putExtra("phone", volunteer.phone)
                        putExtra("email", volunteer.email)
                    }
                    context.startActivity(intent)
                }
            ) {
                Text("View Profile")
            }
        }
    }
}