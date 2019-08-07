package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "geo")
    val geo: List<Double>,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)