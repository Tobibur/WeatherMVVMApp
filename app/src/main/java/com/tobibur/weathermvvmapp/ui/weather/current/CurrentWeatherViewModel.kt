package com.tobibur.weathermvvmapp.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.tobibur.weathermvvmapp.data.provider.UnitProvider
import com.tobibur.weathermvvmapp.data.repository.ForecastRepository
import com.tobibur.weathermvvmapp.internal.UnitSystem
import com.tobibur.weathermvvmapp.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}
