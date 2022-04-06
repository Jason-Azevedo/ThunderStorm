package com.jasonazevedo.thunderstorm.repositories

import com.jasonazevedo.thunderstorm.model.WeatherResponse
import com.jasonazevedo.thunderstorm.model.DayForecast
import com.jasonazevedo.thunderstorm.services.IWeatherAPI

class WeatherForecastRepository(
    val database: Object,
    val IWeatherAPI: IWeatherAPI) : IRepository<DayForecast>{

    override fun getAll(): List<DayForecast> {
        throw NotImplementedError()
    }

    fun refreshForecast(lat: Double, lon: Double)
    : WeatherResponse? {



        throw NotImplementedError()
    }
}