package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.data.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherService {

    suspend fun getDailyAndHourlyForecast(lat: Double, lon: Double): WeatherResponse? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(WeatherAPI::class.java)

        // Could throw an exception!
        return api.getDailyAndHourlyForecast(lat, lon, WeatherAPI.UNITS_METRIC)
    }
}