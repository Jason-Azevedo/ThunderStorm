package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.BuildConfig
import com.jasonazevedo.thunderstorm.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherAPI {
    @GET("data/2.5/onecall?exclude=current,minutely,alerts&appid=${BuildConfig.WEATHER_API_KEY}")
    suspend fun getDailyAndHourlyForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String) : WeatherResponse
}
