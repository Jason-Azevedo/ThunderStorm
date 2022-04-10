package com.jasonazevedo.thunderstorm.repositories

import com.jasonazevedo.thunderstorm.services.WeatherService

interface IWeatherRepository<T, V> {
    suspend fun refreshRepository(service: WeatherService)

    suspend fun getForecastedDays()
    suspend fun getForecastedDay()

    suspend fun getForecastedHours()
    suspend fun getForecastedHour()
}