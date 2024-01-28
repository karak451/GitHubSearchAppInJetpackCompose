package com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.Services.datumAtalakitva
import com.representation.githubsearchappinjetpackcompose.ViewModel.ReszletezesViewModel
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher
import com.representation.githubsearchappinjetpackcompose.ui.theme.sotetSzurke

@Composable
fun DatumCsillagokFork(rvm: ReszletezesViewModel){

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(sotetSzurke, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ){
        Row(){
            Text(
                text = "Létrehozva: ",
                color = feher,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = datumAtalakitva(rvm.repoReszletes.created_at ?: ""),
                color = feher,
                fontStyle = FontStyle.Italic
            )
        }

        Row(){
            Text(
                text = "Legutóbb frissítve: ",
                color = feher,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = datumAtalakitva(rvm.repoReszletes.updated_at ?: ""),
                color = feher,
                fontStyle = FontStyle.Italic
            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ){
            Row(modifier = Modifier.padding(end = 20.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = feher,
                    modifier = Modifier.size(20.dp, 20.dp)
                )

                Text(
                    text = rvm.repoReszletes.stargazers_count.toString(),
                    color = feher,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(){
                Icon(
                    painter = painterResource(id = R.drawable.ic_fork),
                    contentDescription = null,
                    tint = feher,
                    modifier = Modifier.size(20.dp, 20.dp)
                )

                Text(
                    text = rvm.repoReszletes.forks_count.toString(),
                    color = feher,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}