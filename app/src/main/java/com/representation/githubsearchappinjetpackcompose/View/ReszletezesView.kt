package com.representation.githubsearchappinjetpackcompose.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.Model.KeresesStatusz
import com.representation.githubsearchappinjetpackcompose.Services.OnLifecycleEvent
import com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek.DatumCsillagokFork
import com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek.Description
import com.representation.githubsearchappinjetpackcompose.View.ReszletezesViewElemek.OwnerAvatar
import com.representation.githubsearchappinjetpackcompose.View.SharedViews.BetoltesAlatt
import com.representation.githubsearchappinjetpackcompose.View.SharedViews.VisszaGomb
import com.representation.githubsearchappinjetpackcompose.ViewModel.ReszletezesViewModel
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher

@Composable
fun ReszletezesView(navController: NavController, repoURL: String) {
    val rvm = remember { ReszletezesViewModel() }
    val betoltesStatusz by rvm.betoltesStatusz.collectAsState()
    val context = LocalContext.current

    OnLifecycleEvent { owner, event ->
        when (event) {
            Lifecycle.Event.ON_START -> {
                if (repoURL != "") {
                    rvm.repoURL = repoURL
                    rvm.fetchRepositoryDetails()
                }
            }
            else -> { /* kötelező */
            }
        }
    }


    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {
        VisszaGomb(navController)

        if (betoltesStatusz == KeresesStatusz.VEGZETT) {
            Text(
                text = rvm.repoReszletes.name ?: "",
                color = feher,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
            )

            DatumCsillagokFork(rvm)
            Description(rvm, context)
            Text(
                text = "Owner:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = feher,
                modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
            )
            OwnerAvatar(rvm, context)
        } else {
            BetoltesAlatt()
        }
    }
}