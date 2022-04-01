package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.model.WeatherApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherMapService {
    @GET("data/2.5/onecall?lat={lat}&lon={lon}&exclude=current,minutely,alerts&appid={apiKey}")
    fun GetDailyAndHourlyForecast(
        @Path("lat") lat: Long,
        @Path("lon") lon: Long,
        @Path("apiKey") apiKey: String) : Call<WeatherApiResponse>
}