package com.jasonazevedo.thunderstorm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a single hour's worth of weather forecast
 */
@Entity
class HourlyForecast{
    @PrimaryKey var id: Int = 0
    @ColumnInfo(name="temp") var temp: Float = 0f
    @ColumnInfo(name="feels_like_temp") var feelsLike: Float = 0f
    @ColumnInfo(name="wind_speed") var windSpeed: Float = 0f
    @ColumnInfo(name="wind_direction") var windDirection: Int = 0

    /** Probability of precipitation */
    @ColumnInfo(name="pop") var pop: Float = 0f

    @ColumnInfo(name="humidity") var humidity: Int = 0
    @ColumnInfo(name="uv_index") var uvIndex: Int = 0
    @ColumnInfo(name="weather_type") var weatherType: String = ""
    @ColumnInfo(name="weather_description") var weatherDescription: String = ""
}
