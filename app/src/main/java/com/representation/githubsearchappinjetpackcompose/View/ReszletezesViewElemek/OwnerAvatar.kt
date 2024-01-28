package com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import com.representation.githubsearchappinjetpackcompose.ViewModel.ReszletezesViewModel
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.ui.theme.sotetSzurke
import com.representation.githubsearchappinjetpackcompose.ui.theme.vilagosSzurke

@Composable
fun OwnerAvatar(rvm: ReszletezesViewModel, context: Context) {

    val intent = remember {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(rvm.owner.html_url)
        )
    }

Row(
    verticalAlignment = Alignment.Top,
    modifier = Modifier
        .background(vilagosSzurke, shape = RoundedCornerShape(10.dp))
        .padding(10.dp)
){
    AsyncImage(
        model = rvm.owner.avatar_url,
        contentDescription = "avatar kep",
        modifier = Modifier.size(100.dp).clip(RoundedCornerShape(10.dp)),
        contentScale = ContentScale.Fit,
    )

    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 10.dp)){
        Text(
            text = rvm.owner.login ?: "",
            fontWeight = FontWeight.Bold,
            color = sotetSzurke,
        )
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .clickable {
                context.startActivity(intent)
            }){
            Icon(
                painter = painterResource(id = R.drawable.ic_link),
                contentDescription = null,
                tint = sotetSzurke,
                modifier = Modifier.size(20.dp, 20.dp)
            )

            Text(
                text = "GitHub profil",
                color = sotetSzurke,
            )
        }
    }
}
}