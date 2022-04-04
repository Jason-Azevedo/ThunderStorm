package com.jasonazevedo.thunderstorm.data

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    constructor() {}

    var lat: Double? = 0.0
    var lon: Double? = 0.0
    var timezone: String? = ""

    @SerializedName("timezone_offset")
    var timezoneOffset: Int? = 0
    var hourly: Array<HourlyForecast>? = null
    var daily: Array<DailyForecast>? = null
}

/* Data classes for weather response */

class Weather{
    @SerializedName("main") var type: String? = ""
    var description: String? = ""
}

class Temperature{
    var min: Float? = 0f
    var max: Float? = 0f
}

class HourlyForecast{
    @SerializedName("dt") var forecastedTime: Long? = 0
    @SerializedName("temp") var temperature: Float? = 0f
    @SerializedName("feels_like") var feelsLike: Float? = 0f
    @SerializedName("wind_speed") var windSpeed: Float? = 0f
    @SerializedName("wind_deg") var windDirection: Int? = 0
    @SerializedName("pop") var probabilityOfPrecipitation: Float? = 0f
    var humidity: Int? = 0
    var uvi: Float? = 0f
    var clouds: Int? = 0
    var weather: Array<Weather>? = null
}

class DailyForecast{
    @SerializedName("dt") var forecastedTime: Long? = 0
    @SerializedName("sunrise") var sunriseTime: Long? = 0
    @SerializedName("sunset") var sunsetTime: Long? = 0
    @SerializedName("moon_phase") var moonPhase: Float? = 0f
    @SerializedName("temp") var temperature: Temperature? = null
    @SerializedName("wind_speed") var windSpeed: Float? = 0f
    @SerializedName("wind_deg") var windDirection: Int? = 0
    @SerializedName("pop") var probabilityOfPrecipitation: Float? = 0f
    var humidity: Int? = 0
    var uvi: Float? = 0f
    var clouds: Int? = 0
    var weather: Array<Weather>? = null
}