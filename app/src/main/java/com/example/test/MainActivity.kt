package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    var editText:EditText? = null
    var textView:TextView? = null
    var handler = Handler()
    var urlStr:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<View>(R.id.editText) as EditText
        textView = findViewById<View>(R.id.textView) as TextView

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            urlStr = editText?.text.toString()

            val thread = RequestThread()
            thread.start()
        }

    }

    inner class RequestThread: Thread() {
        override fun run() {
            try {
                val url = URL(urlStr)
                val conn: HttpURLConnection? = url.openConnection() as HttpURLConnection?

                if (conn != null) {
                    conn.connectTimeout = 10000
                    conn.requestMethod = "GET"
                    conn.doInput = true
                    conn.doOutput = true

                    val resCode = conn.responseCode
                    val reader = BufferedReader(InputStreamReader(conn.inputStream))
                    var line:String? = null

                    while(true) {
                        line = reader.readLine()
                        if (line == null) {
                            break
                        }

                        println(line)
                    }
                    reader.close()
                    conn.disconnect()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun println(data:String) {
        handler.post{
            textView?.append(data + "\n")
        }

    }
}