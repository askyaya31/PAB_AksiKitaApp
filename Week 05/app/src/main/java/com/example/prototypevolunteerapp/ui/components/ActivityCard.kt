package com.example.prototypevolunteerapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.prototypevolunteerapp.data.model.ActivityData

// ActivityCard menerima lambda onViewDetail di-pass dari ActivitiesScreen
@Composable
fun ActivityCard(
    activity: ActivityData,
    onViewDetail: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(4.dp, Color(0x886B7280)),
        colors = CardDefaults.cardColors(containerColor = Color(0x95A2D365))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = activity.imageRes),
                contentDescription = activity.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = activity.title, style = MaterialTheme.typography.titleMedium)
            Text(text = activity.location, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onViewDetail,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("View Detail")
            }
        }
    }
}
