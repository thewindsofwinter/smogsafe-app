package edu.imsa.andyt.smogsafe.models

import java.util.*

data class UserLocation(var city: String, var longitude: Double, var latitude: Double, var aqi: Int, var timeStamp: Date = Date())