package com.example.test

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", "mike")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}