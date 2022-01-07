package com.example.test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.net.ServerSocket

class ChatService : Service() {

    override fun onCreate() {
        super.onCreate()

        val thread = ServerThread()
        thread.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    class ServerThread : Thread() {
        override fun run() {
            val port = 5001
            try {
                val server = ServerSocket(port)
                Log.d("ServerThread", "서버가 실행됨.")
                while (true) {
                    val socket = server.accept()
                    val inStream = ObjectInputStream(socket.getInputStream())
                    val input = inStream.readObject()
                    Log.d("ServerThread", "input : $input")
                    val outStream = ObjectOutputStream(socket.getOutputStream())
                    outStream.writeObject("$input from server.")
                    outStream.flush()
                    Log.d("ServerThread", "output 보냄.")
                    socket.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}