package com.representation.githubsearchappinjetpackcompose.View.KeresesViewElemek

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.ViewModel.KeresesViewModel
import com.representation.githubsearchappinjetpackcompose.ui.theme.sotetSzurke
import com.representation.githubsearchappinjetpackcompose.ui.theme.vilagosSzurke
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.Services.datumAtalakitva
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ListaElemView(navController: NavController, kvm: KeresesViewModel, index: Int, width: Float){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp, 100.dp)
            .background(vilagosSzurke.copy(alpha = 0.9f), shape = RoundedCornerShape(10.dp))
            .clickable {
                val encodedUrl = URLEncoder.encode(kvm.talalatiLista.items[index].url, StandardCharsets.UTF_8.toString())
                navController.navigate("reszletezes/$encodedUrl")
            }
    ){
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.width((width*0.15).dp)
){
    Icon(
        painter = painterResource(id = R.drawable.ic_star),
        contentDescription = null,
        tint = feher,
        modifier = Modifier.size(24.dp, 24.dp)
    )

    Text(
        text = kvm.talalatiLista.items[index].stargazers_count.toString(),
        color = sotetSzurke,
        fontWeight = FontWeight.Bold
    )
}
        Divider(
            color = sotetSzurke,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight()
                .width(1.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.width((width*0.8).dp)
            ){
Text(
    text = kvm.talalatiLista.items[index].name ?: "",
    fontSize = 22.sp,
    fontWeight = FontWeight.Bold,
    color = sotetSzurke
)

            Text(
                text = kvm.talalatiLista.items[index].description ?: "",
                fontSize = 16.sp,
                maxLines = 2,
                color = sotetSzurke
            )

            Row(modifier = Modifier.padding(bottom = 2.dp)){
                Text(
                    text = "legutóbb módosítva: ",
                fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                    )

                Text(
                    text = datumAtalakitva(kvm.talalatiLista.items[index].updated_at ?: ""),
                    fontSize = 13.sp,
                    color = sotetSzurke
                )
            }
        }
    }
}