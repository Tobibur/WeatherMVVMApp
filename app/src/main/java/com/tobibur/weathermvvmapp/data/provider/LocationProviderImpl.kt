package com.tobibur.weathermvvmapp.data.provider

import com.tobibur.weathermvvmapp.data.db.entitiy.WeatherLocation

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        return true
    }

    override suspend fun getPreferredLocationString(): String {
        return "Los Angeles"
    }
}