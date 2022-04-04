package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.BuildConfig
import com.jasonazevedo.thunderstorm.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/onecall?exclude=current,minutely,alerts&appid=${BuildConfig.WEATHER_API_KEY}")
    suspend fun getDailyAndHourlyForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String) : WeatherResponse

    companion object {
        val UNITS_METRIC = "metric"
        val UNITS_IMPERIAL = "imperial"
    }
}
