package com.jasonazevedo.thunderstorm.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import com.jasonazevedo.thunderstorm.model.HourlyForecast

@Dao
interface HourlyForecastDAO {
    @Query("SELECT * FROM hourlyforecast WHERE forecasted_time = :hour LIMIT 1")
    suspend fun getByHour(hour: Long)

    @Insert
    suspend fun insert(vararg hourForecast: HourlyForecast)

    @Delete
    suspend fun delete(hourForecast: HourlyForecast)
}