package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationWrapper(
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "status")
    val status: String
)