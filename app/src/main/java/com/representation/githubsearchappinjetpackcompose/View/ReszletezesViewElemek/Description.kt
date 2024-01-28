package com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import com.representation.githubsearchappinjetpackcompose.ViewModel.ReszletezesViewModel
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher

@Composable
fun Description(rvm: ReszletezesViewModel, context: Context){

    val intent = remember {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(rvm.repoReszletes.html_url)
        )
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(10.dp)
    ){
        Text(
            text = "Leírás:",
            fontSize = 20.sp,
            color = feher
        )
        Text(
            text = rvm.repoReszletes.description ?: "",
            color = feher
        )
        Row(modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
            context.startActivity(intent)
        }){
            Icon(
                painter = painterResource(id = R.drawable.ic_link),
                contentDescription = null,
                tint = feher,
                modifier = Modifier.size(20.dp, 20.dp)
            )

            Text(
                text = "Ugrás a repository-hoz",
                color = feher,
                fontWeight = FontWeight.Bold
            )
        }
    }
}