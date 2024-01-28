package com.representation.githubsearchappinjetpackcompose.View.SharedViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.ui.theme.piros

@Composable
fun VisszaGomb(
    navController: NavController,
) {
    Row(
        modifier = Modifier
            .padding(start = 0.dp)
            .clickable {
                navController.navigate("kereses") {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_vissza),
            contentDescription = "visszalépés",
            tint = piros,
            modifier = Modifier
                .height(16.dp),
        )
        Text(
            "Vissza",
            fontWeight = FontWeight.Bold,
            color = piros,
            modifier = Modifier
        )
    }
}