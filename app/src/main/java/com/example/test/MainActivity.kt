package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.net.ServerSocket

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
//            val thread = MainActivity.ServerThread()
//            thread.start()
            val intent = Intent(applicationContext, ChatService::class.java)
            startService(intent)

        }
    }
    /*
    internal class ServerThread : Thread() {
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
    } */
}