package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Time(
    @Json(name = "s")
    val s: String,
    @Json(name = "tz")
    val tz: String,
    @Json(name = "v")
    val v: Int
)