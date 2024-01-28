package com.representation.githubsearchappinjetpackcompose.View.SharedViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher

@Composable
fun BetoltesAlatt(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ){
        CircularProgressIndicator(
            modifier = Modifier.width(40.dp),
            color = feher
        )
        Text(
            text = "adatok betöltése...",
            color = feher
        )
    }
}