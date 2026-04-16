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
        modifier = Modifier.fillMaxWidth().height(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
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
                    .height(120.dp)
                    .width(96.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
                Text(text = volunteer.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = volunteer.education,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = volunteer.description.lines().firstOrNull() ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
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
                    },
                    modifier = Modifier.align(Alignment.End)
                                        .height(35.dp)
                    ,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
                ) {
                    Text("View Profile")
                }
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}