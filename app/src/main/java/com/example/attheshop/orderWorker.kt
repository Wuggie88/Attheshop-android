package com.example.attheshop

import android.content.Context
import android.telephony.SmsManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class orderWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do some work coding here
        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage("60186460", null, "This is a test message", null, null)

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}
