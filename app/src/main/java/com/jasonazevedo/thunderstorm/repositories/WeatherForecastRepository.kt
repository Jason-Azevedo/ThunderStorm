package com.jasonazevedo.thunderstorm.repositories

import com.jasonazevedo.thunderstorm.data.WeatherResponse
import com.jasonazevedo.thunderstorm.model.WeatherForecast
import com.jasonazevedo.thunderstorm.services.WeatherAPI

class WeatherForecastRepository(
    val database: Object,
    val weatherAPI: WeatherAPI) : IRepository<WeatherForecast>{

    override fun getAll(): List<WeatherForecast> {
        throw NotImplementedError()
    }

    fun refreshForecast(lat: Double, lon: Double)
    : WeatherResponse? {



        throw NotImplementedError()
    }
}