package com.jasonazevedo.thunderstorm.model

import com.jasonazevedo.thunderstorm.model.DailyForecast
import com.jasonazevedo.thunderstorm.model.HourlyForecast

class WeatherResponse {
    // Location details for user settings
    var lat: Double = 0.0
    var lon: Double = 0.0

    var hourly: Array<HourlyForecast>? = null
    var daily: Array<DailyForecast>? = null
}
