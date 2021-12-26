package com.example.test

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate() 호출됨", Toast.LENGTH_LONG).show()

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy() 호출됨", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause() 호출됨", Toast.LENGTH_LONG).show()

        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("name", "소녀시대")
        editor.commit()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() 호출됨", Toast.LENGTH_LONG).show()

        val pref = getSharedPreferences("pref", MODE_PRIVATE)
        if (pref != null) {
            val name = pref.getString("name", "")
            Toast.makeText(this, "복구된 이름 : $name", Toast.LENGTH_LONG).show()
        }
    }
}