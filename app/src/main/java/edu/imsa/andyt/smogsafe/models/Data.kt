package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "aqi")
    val aqi: Int,
    @Json(name = "attributions")
    val attributions: List<Attribution>,
    @Json(name = "city")
    val city: City,
    @Json(name = "debug")
    val debug: Debug,
    @Json(name = "dominentpol")
    val dominentpol: String,
    @Json(name = "iaqi")
    val iaqi: Iaqi,
    @Json(name = "idx")
    val idx: Int,
    @Json(name = "time")
    val time: Time
)