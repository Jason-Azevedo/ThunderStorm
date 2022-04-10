package com.jasonazevedo.thunderstorm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Represents a single days worth of weather forecast
 */
@Entity(tableName = "dailyForecast", primaryKeys = ["forecasted_time"])
data class DailyForecast(
    @ColumnInfo(name="forecasted_time") var date: Long,
    @ColumnInfo(name ="sunrise_time") var sunriseTime: Long?,
    @ColumnInfo(name="sunset_time") var sunsetTime: Long?,
    @ColumnInfo(name="moon_phase") var moonPhase: Float?,
    @ColumnInfo(name="min_temp") var minTemp: Float?,
    @ColumnInfo(name="max_temp") var maxTemp: Float?,
    @ColumnInfo(name="wind_speed") var windSpeed: Float?,
    @ColumnInfo(name="wind_direction") var windDirection: Int?,

    /** Probability of precipitation */
    @ColumnInfo(name="pop") var pop: Float?,

    @ColumnInfo(name="humidity") var humidity: Int?,
    @ColumnInfo(name="uv_index") var uvIndex: Int?,
    @ColumnInfo(name="weather_type") var weatherType: String?,
    @ColumnInfo(name="weather_description") var weatherDescription: String?
)


