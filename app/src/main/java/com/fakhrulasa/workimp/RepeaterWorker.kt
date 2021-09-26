package com.fakhrulasa.workimp


import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*
import kotlin.concurrent.schedule
import android.R
import android.app.Notification
import android.app.NotificationChannel

import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService


class RepeaterWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {
        repeatTask()
        return Result.success()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun repeatTask() {

    Timer().schedule(5000) {
        Log.d("WorkDone", TimeZone.LONG.toString())
    }
}