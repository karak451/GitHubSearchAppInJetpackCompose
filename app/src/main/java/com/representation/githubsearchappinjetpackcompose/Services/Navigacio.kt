package com.representation.githubsearchappinjetpackcompose.Services


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.representation.githubsearchappinjetpackcompose.View.KeresesView
import com.representation.githubsearchappinjetpackcompose.View.ReszletezesView


@Composable
fun Navigacio() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "kereses"
    ) {

        composable(
            route = "kereses"
        ) {
            KeresesView(
                navController
            )
        }//: nyitó

        composable(
            route = "reszletezes/{repoURL}",
            arguments = listOf(
                navArgument(name = "repoURL") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val repoURL = it.arguments?.getString("repoURL")!!
            ReszletezesView(
                navController,
                repoURL
            )
        }//: nyitó


    }


}