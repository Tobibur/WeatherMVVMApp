package com.tobibur.weathermvvmapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tobibur.weathermvvmapp.data.db.entitiy.CURRENT_WEATHER_ID
import com.tobibur.weathermvvmapp.data.db.entitiy.CurrentWeatherEntry
import com.tobibur.weathermvvmapp.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.tobibur.weathermvvmapp.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}