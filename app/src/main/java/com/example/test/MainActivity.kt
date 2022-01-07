package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    var handler = ValueHandler()
    var handler2 = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<View>(R.id.textView) as TextView

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
//            val thread = BackgroundThread()
//            thread.start()


//                BackgroundThread thread = new BackgroundThread();
//                thread.start();
            Thread(object : Runnable {
                var value = 0
                var running = false
                override fun run() {
                    running = true
                    while (running) {
                        value += 1

                        handler2.post { textView?.text = "현재 값 : $value" }

                        try {
                            Thread.sleep(1000)
                        } catch (e: Exception) {
                        }
                    }
                }
            }).start()
        }

        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {
            //textView.setText("현재 값 : " + value);
        }
    }

    inner class BackgroundThread : Thread() {
        var value = 0
        var running = false

        override fun run() {
            running = true
            while (running) {
                value += 1
                val message: Message = handler.obtainMessage()
                val bundle = Bundle()
                bundle.putInt("value", value)
                message.data = bundle
                handler.sendMessage(message)
                try {
                    sleep(1000)
                } catch (e: Exception) {
                }
            }
        }
    }

    inner class ValueHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val bundle = msg.data
            val value = bundle.getInt("value")
            textView?.text = "현재 값 : $value"
            msg.data
        }
    }


}