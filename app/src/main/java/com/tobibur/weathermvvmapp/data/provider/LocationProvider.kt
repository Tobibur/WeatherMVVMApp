package com.tobibur.weathermvvmapp.data.provider

import com.tobibur.weathermvvmapp.data.db.entitiy.WeatherLocation

interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean
    suspend fun getPreferredLocationString(): String
}