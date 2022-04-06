package com.jasonazevedo.thunderstorm

import com.jasonazevedo.thunderstorm.data.WeatherResponse
import com.jasonazevedo.thunderstorm.services.WeatherService
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Before
import org.junit.Test

class WeatherServiceTest {
    lateinit var weatherService: WeatherService

    @Before
    fun setup() {
        weatherService = WeatherService()
    }

    @Test
    fun getDailyAndHourlyForecast_NotNull() {
        var response: WeatherResponse?

        runBlocking {
               response = weatherService
                   .getDailyAndHourlyForecast(
                       -33.977074,
                       22.457581,
                       WeatherService.Units.METRIC)
        }

        Assert.assertNotNull(response)
    }
}