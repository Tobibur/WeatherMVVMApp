package com.tobibur.weathermvvmapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.tobibur.weathermvvmapp.data.db.entitiy.CurrentWeatherEntry
import com.tobibur.weathermvvmapp.data.db.entitiy.Location

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)