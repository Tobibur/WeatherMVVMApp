package com.tobibur.weathermvvmapp.data.network

import androidx.lifecycle.LiveData
import com.tobibur.weathermvvmapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        language: String
    )
}