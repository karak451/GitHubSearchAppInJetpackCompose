package com.representation.githubsearchappinjetpackcompose.Services

import com.representation.githubsearchappinjetpackcompose.Model.RepositoryReszletes
import com.representation.githubsearchappinjetpackcompose.Model.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url




interface ApiService {
    //kulcsszó alapján
    @GET("search/repositories")
    fun getReposByKeywords(@Query("q") q: String): Call<Root>

    //url alapján
    @GET
    fun getRepoByURL(@Url repoURL: String): Call<RepositoryReszletes>
}