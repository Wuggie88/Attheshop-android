package com.example.attheshop

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class orderWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do some work coding here
        println("Testing workmanager")

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}
