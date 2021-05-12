package com.example.attheshop

import android.content.Context
import android.telephony.SmsManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class orderWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // This uses the sms Manager, to send a message to the customer.
        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage("60186460", null, "There's a new update on your order in At The Shop", null, null)

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}
