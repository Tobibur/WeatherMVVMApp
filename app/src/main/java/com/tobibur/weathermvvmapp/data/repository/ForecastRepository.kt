package com.tobibur.weathermvvmapp.data.repository

import androidx.lifecycle.LiveData
import com.tobibur.weathermvvmapp.data.db.entitiy.WeatherLocation
import com.tobibur.weathermvvmapp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}