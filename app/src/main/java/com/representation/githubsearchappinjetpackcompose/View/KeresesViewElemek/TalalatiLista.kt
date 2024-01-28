package com.representation.githubsearchappinjetpackcompose.View.KeresesViewElemek

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.ViewModel.KeresesViewModel

@Composable
fun TalalatiLista(navController: NavController, kvm: KeresesViewModel, width: Float){
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.Start
        ) {

            itemsIndexed(kvm.talalatiLista.items) { index, item ->
                ListaElemView(navController, kvm, index, width)
            }
            }

    }
}