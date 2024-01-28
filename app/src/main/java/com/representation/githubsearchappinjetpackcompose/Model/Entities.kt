package com.representation.githubsearchappinjetpackcompose.Model

//MARK: listázáshoz
data class Root(
    val items: List<Repository>
    )

data class Repository(
    val name: String? = "gyk_ures",
    val url: String? = "",
    val updated_at: String? = "",
    val description: String? = "",
    val stargazers_count: Int? = 0
)

//MARK: részletes nézethez
data class RepositoryReszletes(
    val name: String? = "gyk_ures",
    val description: String? = "",
    val owner: Owner? = Owner(),
    val html_url: String? = "",
    val stargazers_count: Int? = 0,
    val forks_count: Int? = 0,
    val created_at: String? = "",
    val updated_at: String? = ""
)

data class Owner(
    val login : String? = "",
    val avatar_url: String? = "",
    val html_url: String? = ""
)

enum class KeresesStatusz{
    KERES, HIBA, VEGZETT, OFF;
}

