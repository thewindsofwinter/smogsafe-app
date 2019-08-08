package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Iaqi(
    @Json(name = "co")
    val co: Co = Co(-1.0),
    @Json(name = "h")
    val h: H = H(-1.0),
    @Json(name = "no2")
    val no2: No2 = No2(-1.0),
    @Json(name = "o3")
    val o3: O3 = O3(-1.0),
    @Json(name = "p")
    val p: P = P(-1.0),
    @Json(name = "pm10")
    val pm10: Pm10 = Pm10(-1.0),
    @Json(name = "pm25")
    val pm25: Pm25 = Pm25(-1.0),
    @Json(name = "so2")
    val so2: So2 = So2(-1.0),
    @Json(name = "w")
    val w: W = W(-1.0)
)