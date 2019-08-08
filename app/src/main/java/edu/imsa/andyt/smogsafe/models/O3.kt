package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class O3(
    @Json(name = "v")
    val v: Double
)