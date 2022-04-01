package com.jasonazevedo.thunderstorm.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class FetchWeatherForecastWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams){

    override fun doWork(): Result {
        // This is where the magic happens!
        TODO("Not yet implemented")
    }
}