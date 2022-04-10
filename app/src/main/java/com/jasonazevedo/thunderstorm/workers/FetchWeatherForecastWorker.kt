package com.jasonazevedo.thunderstorm.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.jasonazevedo.thunderstorm.repositories.WeatherRepository

class FetchWeatherForecastWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    weatherRepository: WeatherRepository) : Worker(appContext, workerParams){

    override fun doWork(): Result {
        // This is where the magic happens!
        TODO("Not yet implemented")
    }
}