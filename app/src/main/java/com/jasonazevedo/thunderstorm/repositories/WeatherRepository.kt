package com.jasonazevedo.thunderstorm.repositories

import android.icu.util.Calendar
import com.jasonazevedo.thunderstorm.dao.DailyForecastDAO
import com.jasonazevedo.thunderstorm.dao.HourlyForecastDAO
import com.jasonazevedo.thunderstorm.database.AppDatabase
import com.jasonazevedo.thunderstorm.model.WeatherResponse
import com.jasonazevedo.thunderstorm.model.DailyForecast
import com.jasonazevedo.thunderstorm.model.HourlyForecast
import com.jasonazevedo.thunderstorm.services.WeatherService
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

class WeatherRepository(db: AppDatabase) {
    private val hourlyDao = db.hourlyForecastDao()
    private val dailyDao = db.dailyForecastDao()

    suspend fun refreshRepository(service: WeatherService) {

        throw NotImplementedError()
    }

    suspend fun getForecastedDays(): List<DailyForecast>? {
        TODO("Not yet implemented")
    }

    /**
     * Gets the weather forecast for the date provided
     * @param date - The date of the weather forecast
     */
    suspend fun getForecastedDay(date: LocalDate): DailyForecast? {
        val epochTime = date.toEpochDay()
        val forecast = dailyDao.getByDate(epochTime)

        return forecast
    }

    suspend fun getForecastedHours(): List<HourlyForecast>? {
        TODO("Not yet implemented")
    }

    /**
     * Gets the weather forecast for the date time hour provided
     * @param dateTime - The LocalDateTime of the hour forecast you want,
     * not affected by minutes,seconds,nanoseconds.
     */
    suspend fun getForecastedHour(dateTime: LocalDateTime): HourlyForecast? {
        // Remove any minutes, seconds, nanoseconds
        var trimmedDateTime = dateTime.minusMinutes(dateTime.minute.toLong())
        trimmedDateTime = trimmedDateTime.minusSeconds(dateTime.second.toLong())
        trimmedDateTime = trimmedDateTime.minusNanos(dateTime.nano.toLong())

        val epochTime = trimmedDateTime.toEpochSecond(ZoneOffset.UTC)
        val forecast = hourlyDao.getByHour(epochTime)

        return forecast
    }
}