package com.jasonazevedo.thunderstorm

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jasonazevedo.thunderstorm.dao.DailyForecastDAO
import com.jasonazevedo.thunderstorm.dao.HourlyForecastDAO
import com.jasonazevedo.thunderstorm.database.AppDatabase
import com.jasonazevedo.thunderstorm.model.DailyForecast
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
    }

    @After
    @Throws(IOException::class)
    fun cleanup() {
        db.close()
    }

    @Test
    fun getForecastedDay_June15th_ShouldReturnJune15thForecast() {
        val date = LocalDate.parse("2022-07-15")
        val epochDate = date.toEpochDay()
        var forecast: DailyForecast?

        // Setup
        runBlocking {
        dailyDao.insert(DailyForecast(
             epochDate, 54, 32,3f,
            32f, 2f, 3f, 22,32f,
            32, 32, "Clouds", "cloudy"))


            // Fetch the forecast for the provided date
            forecast = repository.getForecastedDay(date)
        }

        Assert.assertNotNull(forecast)
        Assert.assertEquals(forecast?.date, epochDate)
    }
}