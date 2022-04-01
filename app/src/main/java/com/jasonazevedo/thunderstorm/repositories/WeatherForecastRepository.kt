package com.jasonazevedo.thunderstorm.repositories

import com.jasonazevedo.thunderstorm.model.WeatherForecast

class WeatherForecastRepository : IRepository<WeatherForecast>{
    override fun getAll(): List<WeatherForecast> {
        TODO("Not yet implemented")
    }

    fun fetchWeatherForecast() {

    }
}