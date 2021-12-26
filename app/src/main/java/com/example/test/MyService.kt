package com.example.test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class MyService : Service() {
    private val TAG = "MyService"
    fun MyService() {}

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() 호출됨.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand() 호출됨.")
        if (intent == null) {
            return START_STICKY
        } else {
            processCommand(intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun processCommand(intent: Intent) {
        val command = intent.getStringExtra("command")
        val name = intent.getStringExtra("name")

        Log.d(TAG, "전달받은 데이터 : $command, $name")

        try {
            Thread.sleep(5000)
        } catch (e: Exception) {
        }
        val showIntent = Intent(applicationContext, MainActivity::class.java)
        showIntent.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
        )
        showIntent.putExtra("command", "show")
        showIntent.putExtra("name", name + "from service.")
        startActivity(showIntent)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() 호출됨.")
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

}