package com.tobibur.weathermvvmapp.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.tobibur.weathermvvmapp.data.repository.ForecastRepository
import com.tobibur.weathermvvmapp.internal.UnitSystem
import com.tobibur.weathermvvmapp.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC //get from settings later

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
