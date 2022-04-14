package com.jasonazevedo.thunderstorm.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import com.jasonazevedo.thunderstorm.model.DailyForecast

@Dao
interface DailyForecastDAO {
    @Query("SELECT * FROM dailyForecast WHERE forecasted_time = :date LIMIT 1")
    suspend fun getByDate(date: Long): DailyForecast?

    @Insert
    suspend fun insert(vararg dailyForecast: DailyForecast)

    @Delete
    suspend fun delete(dailyForecast: DailyForecast)
}