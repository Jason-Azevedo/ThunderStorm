package com.jasonazevedo.thunderstorm

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jasonazevedo.thunderstorm.dao.DailyForecastDAO
import com.jasonazevedo.thunderstorm.dao.HourlyForecastDAO
import com.jasonazevedo.thunderstorm.database.AppDatabase
import com.jasonazevedo.thunderstorm.model.DailyForecast
import com.jasonazevedo.thunderstorm.model.HourlyForecast
import com.jasonazevedo.thunderstorm.repositories.WeatherRepository
import com.jasonazevedo.thunderstorm.services.WeatherService
import kotlinx.coroutines.runBlocking
import java.io.IOException

import org.junit.runner.RunWith
import org.junit.Before
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class WeatherRepositoryTest {

    private lateinit var repository: WeatherRepository
    private lateinit var service: WeatherService
    private lateinit var hourlyDao: HourlyForecastDAO
    private lateinit var dailyDao: DailyForecastDAO
    private lateinit var db: AppDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        hourlyDao = db.hourlyForecastDao()
        dailyDao = db.dailyForecastDao()

        service = WeatherService()
        repository = WeatherRepository(db)

        // Setup
        runBlocking {
            // Setup hourly table
            hourlyDao.insert(
                HourlyForecast(
                    LocalDateTime.parse("2022-06-15T08:00:00.000").toEpochSecond(ZoneOffset.UTC),
                    54f, 32f,3f, 32,
                    2f, 3, 22,"Cloudy",
                    "cloudy"),
                HourlyForecast(
                    LocalDateTime.parse("2022-06-15T09:00:00.000").toEpochSecond(ZoneOffset.UTC),
                    54f, 32f,3f,
                    32, 2f, 3, 22,"Cloudy",
                    "cloudy"))

            // Setup daily table
            dailyDao.insert(DailyForecast(
                LocalDate.parse("2022-06-15").toEpochDay(), 54, 32,3f,
                32f, 2f, 3f, 22,32f,
                32, 32, "Clouds", "cloudy"),
                DailyForecast(
                    LocalDate.parse("2022-06-16").toEpochDay(), 54, 32,3f,
                    32f, 2f, 3f, 22,32f,
                    32, 32, "Clouds", "cloudy"))

        }
    }

    @After
    @Throws(IOException::class)
    fun cleanup() {
        db.close()
    }

    @Test
    fun getForecastedDay_June15th_ShouldReturnJune15thForecast() {
        val date = LocalDate.parse("2022-06-15")
        val epochDate = date.toEpochDay()
        var forecast: DailyForecast?

        runBlocking {
            forecast = repository.getForecastedDay(date)
        }

        Assert.assertNotNull(forecast)
        Assert.assertEquals(forecast?.date, epochDate)
    }

    @Test
    fun getForecastedHour_8AMJune15th_ShouldReturn8AMJune15th() {
        val dateTime = LocalDateTime.parse("2022-06-15T08:00:00.000")
        val epochTime = dateTime.toEpochSecond(ZoneOffset.UTC)
        var forecast: HourlyForecast?

        runBlocking {
                forecast = repository.getForecastedHour(dateTime)
        }

        Assert.assertNotNull(forecast)
        Assert.assertEquals(forecast?.dateTime, epochTime)
    }

    @Test
    fun getForecastedHour_8h23mAMJune15th_ShouldReturn8AMJune15th() {
        val dateTime = LocalDateTime.parse("2022-06-15T08:00:00.000")
        val dateTimeWithMinutesSeconds = LocalDateTime.parse("2022-06-15T08:23:13.210")
        val epochTime = dateTime.toEpochSecond(ZoneOffset.UTC)
        var forecast: HourlyForecast?

        runBlocking {
            forecast = repository.getForecastedHour(dateTimeWithMinutesSeconds)
        }

        Assert.assertNotNull(forecast)
        Assert.assertEquals(forecast?.dateTime, epochTime)
    }
}