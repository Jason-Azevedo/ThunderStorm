package com.jasonazevedo.thunderstorm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Represents a single days worth of weather forecast
 */
@Entity
class DailyForecast{
    @PrimaryKey var id: Int = 0
    @ColumnInfo(name = "sunrise_time") var sunriseTime: Long = 0
    @ColumnInfo(name="sunset_time") var sunsetTime: Long = 0
    @ColumnInfo(name="moon_phase") var moonPhase: Float = 0f
    @ColumnInfo(name="min_temp") var minTemp: Float = 0f
    @ColumnInfo(name="max_temp") var maxTemp: Float = 0f
    @ColumnInfo(name="wind_speed") var windSpeed: Float = 0f
    @ColumnInfo(name="wind_direction") var windDirection: Int = 0

    /** Probability of precipitation */
    @ColumnInfo(name="pop") var pop: Float = 0f

    @ColumnInfo(name="humidity") var humidity: Int = 0
    @ColumnInfo(name="uv_index") var uvIndex: Int = 0
    @ColumnInfo(name="weather_type") var weatherType: String = ""
    @ColumnInfo(name="weather_description") var weatherDescription: String = ""
}
