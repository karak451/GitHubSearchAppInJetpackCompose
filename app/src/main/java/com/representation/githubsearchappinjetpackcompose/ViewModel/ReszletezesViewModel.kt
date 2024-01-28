package com.representation.githubsearchappinjetpackcompose.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.representation.githubsearchappinjetpackcompose.Model.KeresesStatusz
import com.representation.githubsearchappinjetpackcompose.Model.Owner
import com.representation.githubsearchappinjetpackcompose.Model.RepositoryReszletes
import com.representation.githubsearchappinjetpackcompose.Model.Root
import com.representation.githubsearchappinjetpackcompose.Services.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ReszletezesViewModel : ViewModel() {

    var repoURL by mutableStateOf("")
    var repoReszletes by mutableStateOf(RepositoryReszletes())
    var owner by mutableStateOf(Owner())

    init{
        Log.d("testing", "viemodel betöltött")
    }
    private val _betoltesStatusz = MutableStateFlow(KeresesStatusz.OFF)
    val betoltesStatusz = _betoltesStatusz.asStateFlow()


    fun fetchRepositoryDetails(){
        changeStatuszValue(KeresesStatusz.KERES)
        val urlString = repoURL
        Log.d("testing", "url: $urlString")

        val call = ApiClient.apiService.getRepoByURL(urlString)

        call.enqueue(object : Callback<RepositoryReszletes> {
            override fun onResponse(call: Call<RepositoryReszletes>, response: Response<RepositoryReszletes>) {
                if (response.isSuccessful) {
                    repoReszletes = response.body()!!
                    owner = repoReszletes.owner!!
                    changeStatuszValue(KeresesStatusz.VEGZETT)
                } else {
                    // Handle error
                    changeStatuszValue(KeresesStatusz.HIBA)
                }
            }

            override fun onFailure(call: Call<RepositoryReszletes>, t: Throwable) {
                changeStatuszValue(KeresesStatusz.HIBA)
            }
        })
    }

    private fun changeStatuszValue(value : KeresesStatusz){
        _betoltesStatusz.value = value
    }
}