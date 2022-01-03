package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), FragmentCallback {
    var fragment1: Fragment1? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<View>(R.id.button) as Button
        button!!.setOnClickListener {
            if (fragment1 != null) {
                fragment1!!.onCommandFromActivity("show", "액티비티로부터 전달됨.")
            }
        }

        fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment1!!).commit()
    }

    override fun onCommand(command: String?, data: String?) {
        button!!.text = data
    }
}