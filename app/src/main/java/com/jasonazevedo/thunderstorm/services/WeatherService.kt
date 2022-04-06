package com.jasonazevedo.thunderstorm.services

import com.jasonazevedo.thunderstorm.model.WeatherResponse
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

        val api = retrofit.create(IWeatherAPI::class.java)

        // Could throw an IOException!
        return api.getDailyAndHourlyForecast(lat, lon, units)
    }

    object Units {
        const val METRIC   = "metric"
        const val IMPERIAL = "imperial"
        const val STANDARD = "standard"
    }
}