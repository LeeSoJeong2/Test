package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener { finish() }

        val passedIntent = intent
        processIntent(passedIntent)
    }

    private fun processIntent(intent: Intent?) {
        if (intent != null) {
            val names = intent.getSerializableExtra("names") as ArrayList<String>?
            if (names != null) {
                Toast.makeText(
                    applicationContext,
                    "전달받은 이름 리스트 갯수 : " + names.size,
                    Toast.LENGTH_LONG
                ).show()
            }

            val data: SimpleData? = intent.getParcelableExtra("data")
            if (data != null) {
                Toast.makeText(
                    applicationContext,
                    "전달받은 SimpleData : " + data.message,
                    Toast.LENGTH_LONG
                ).show()

            }
        }
    }
}