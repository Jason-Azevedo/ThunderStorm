package com.jasonazevedo.thunderstorm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a single hour's worth of weather forecast
 */
@Entity
data class HourlyForecast(
    @PrimaryKey var id: Int,
    @ColumnInfo(name="forecasted_time") var dateTime: String?,
    @ColumnInfo(name="temp") var temp: Float?,
    @ColumnInfo(name="feels_like_temp") var feelsLike: Float?,
    @ColumnInfo(name="wind_speed") var windSpeed: Float?,
    @ColumnInfo(name="wind_direction") var windDirection: Int?,

    /** Probability of precipitation */
    @ColumnInfo(name="pop") var pop: Float?,

    @ColumnInfo(name="humidity") var humidity: Int?,
    @ColumnInfo(name="uv_index") var uvIndex: Int?,
    @ColumnInfo(name="weather_type") var weatherType: String?,
    @ColumnInfo(name="weather_description") var weatherDescription: String?
)
