package com.jasonazevedo.thunderstorm.model

import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
    val lat: Long,
    val lon: Long,
    val timezone: String,
    @SerializedName("timezone_offset") val timezoneOffset: Int,
    val hourly: Array<HourlyForecast>,
    val daily: Array<DailyForecast>
)

data class Weather(
    @SerializedName("main") val type: String,
    val description: String,
)

data class Temperature(
    val min: Float,
    val max: Float
)

data class HourlyForecast(
    @SerializedName("dt") val forecastedTime: Long,
    @SerializedName("temp") val temperature: Float,
    @SerializedName("feels_like") val feelsLike: Float,
    val humidity: Int,
    val uvi: Int,
    val clouds: Int,
    @SerializedName("wind_speed") val windSpeed: Float,
    @SerializedName("wind_deg") val windDirection: Int,
    @SerializedName("pop") val probabilityOfPrecipitation: Float,
    val weather: Array<Weather>
)

data class DailyForecast(
    @SerializedName("dt") val forecastedTime: Long,
    @SerializedName("sunrise") val sunriseTime: Long,
    @SerializedName("sunset") val sunsetTime: Long,
    @SerializedName("moonrise") val moonRiseTime: Long,
    @SerializedName("moonset") val moonSetTime: Long,
    @SerializedName("moon_phase") val moonPhase: Float,
    @SerializedName("temp") val temperature: Temperature,
    val humidity: Int,
    val uvi: Int,
    val clouds: Int,
    @SerializedName("wind_speed") val windSpeed: Float,
    @SerializedName("wind_deg") val windDirection: Int,
    @SerializedName("pop") val probabilityOfPrecipitation: Float,
    val weather: Array<Weather>
)
