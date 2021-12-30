package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var fragment1: MainFragment? = null
    var fragment2: MenuFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1 = MainFragment()
        fragment2 = MenuFragment()

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment1!!).commit()
        }

        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment2!!).commit()
        }

    }

    fun onFragmentChange(index: Int) {
        if (index == 0) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment1!!).commit()
        } else if (index == 1) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment2!!).commit()
        }
    }
}