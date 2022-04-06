package com.jasonazevedo.thunderstorm

import com.jasonazevedo.thunderstorm.repositories.WeatherForecastRepository
import com.jasonazevedo.thunderstorm.services.IWeatherAPI
import org.junit.Test

import org.junit.Before

class DayForecastRepositoryTest {

    lateinit var repository: WeatherForecastRepository
    lateinit var API: IWeatherAPI

    @Before
    fun setup() {

    }

    /** Test if the repo can successfully fetch and deserialize the weather forecast */
    @Test
    fun fetchWeatherForecastTest() {

    }
}