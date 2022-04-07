package com.jasonazevedo.thunderstorm.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.jasonazevedo.thunderstorm.dao.DailyForecastDAO
import com.jasonazevedo.thunderstorm.dao.HourlyForecastDAO
import com.jasonazevedo.thunderstorm.model.DailyForecast
import com.jasonazevedo.thunderstorm.model.HourlyForecast

@Database(entities = [HourlyForecast::class, DailyForecast::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dailyForecastDao(): DailyForecastDAO
    abstract fun hourlyForecastDao(): HourlyForecastDAO
}