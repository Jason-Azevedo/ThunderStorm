package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.data.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class WeatherService {

    /**
     * Gets the daily and weather forecast from the weather api.
     * @throws [IOException]
     * @param lat The latitude of the area you want the weather forecast for.
     * @param lon The longitude of the area you want the weather forecast for.
     * @param units The [WeatherService.Units] that you want the weather api response
     * to be in.
     */
    suspend fun getDailyAndHourlyForecast(lat: Double, lon: Double, units: String): WeatherResponse? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(WeatherAPI::class.java)

        // Could throw an IOException!
        return api.getDailyAndHourlyForecast(lat, lon, units)
    }

    object Units {
        val METRIC = "metric"
        val IMPERIAL = "imperial"
        val STANDARD = "standard"
    }
}