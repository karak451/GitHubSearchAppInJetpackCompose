package com.representation.githubsearchappinjetpackcompose.Services

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun datumAtalakitva(gitHubDatum: String): String {

    val f = DateTimeFormatter.ISO_INSTANT
    val gitHubDateTime = Instant.from(f.parse(gitHubDatum))
    val sajatFormatter =
        DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm").withZone(ZoneId.systemDefault())
    val instantStr = sajatFormatter.format(gitHubDateTime)

    return instantStr
}