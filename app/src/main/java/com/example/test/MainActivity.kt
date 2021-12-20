package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    var container: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById<View>(R.id.container) as FrameLayout
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val inflater =
                getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.sub1, container, true)
        }
    }
}