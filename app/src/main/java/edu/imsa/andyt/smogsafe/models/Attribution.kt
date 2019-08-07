package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attribution(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)