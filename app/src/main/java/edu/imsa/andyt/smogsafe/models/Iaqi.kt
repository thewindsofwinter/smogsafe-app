package edu.imsa.andyt.smogsafe.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Iaqi(
    @Json(name = "co")
    val co: Co = Co(2.0),
    @Json(name = "h")
    val h: H = H(2.0),
    @Json(name = "no2")
    val no2: No2 = No2(2.0),
    @Json(name = "o3")
    val o3: O3 = O3(2),
    @Json(name = "p")
    val p: P = P(2.0),
    @Json(name = "pm10")
    val pm10: Pm10 = Pm10(2),
    @Json(name = "pm25")
    val pm25: Pm25 = Pm25(2),
    @Json(name = "so2")
    val so2: So2 = So2(2.0),
    @Json(name = "w")
    val w: W = W(2.0)
)