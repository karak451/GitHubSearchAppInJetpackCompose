package com.representation.githubsearchappinjetpackcompose.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.representation.githubsearchappinjetpackcompose.Model.KeresesStatusz
import com.representation.githubsearchappinjetpackcompose.Model.Repository
import com.representation.githubsearchappinjetpackcompose.Model.Root
import com.representation.githubsearchappinjetpackcompose.Services.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.min


class KeresesViewModel : ViewModel() {

    var keresoMezoQuery by mutableStateOf("")
    var minositoMezoQuery by mutableStateOf("")
    var talalatiLista by mutableStateOf(Root(items = listOf(Repository())))

    private val _keresesStatusz = MutableStateFlow(KeresesStatusz.OFF)
    val keresesStatusz = _keresesStatusz.asStateFlow()

    fun fetchGitHubReopositories(){
        changeStatuszValue(KeresesStatusz.KERES)
        var standardizedQuery = keresoMezoQuery
        standardizedQuery = standardizedQuery.replace(" ", "+")
        if(minositoMezoQuery != ""){
            standardizedQuery = standardizedQuery.plus("+language:").plus(minositoMezoQuery.replace(" ", "+"))
        }

        val call = ApiClient.apiService.getReposByKeywords(standardizedQuery)

        call.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                if (response.isSuccessful) {
                    talalatiLista = response.body()!!
                    changeStatuszValue(KeresesStatusz.VEGZETT)
                } else {
                    // Handle error
                    changeStatuszValue(KeresesStatusz.HIBA)
                }
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                changeStatuszValue(KeresesStatusz.HIBA)
            }
        })
    }

    private fun changeStatuszValue(value : KeresesStatusz){
        _keresesStatusz.value = value
    }

}