package com.fakhrulasa.workimp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private lateinit var text:TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.textBox)


        text.setOnClickListener{
            WorkManager
                .getInstance(this)
                .enqueue(taskRepeaterRequest)
            text.text="Work started!"
            Handler(Looper.getMainLooper()).postDelayed({
                text.text="Work DONE!"
            }, 5000)
        }

    }

    val taskRepeaterRequest:WorkRequest= OneTimeWorkRequestBuilder<RepeaterWorker>()
        .build()
}