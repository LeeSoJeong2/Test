package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "위치가 바뀐 토스트", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 200, 200)
            toast.show()
        }

        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {
            val layout = layoutInflater.inflate(
                R.layout.toastborder,
                //error
                // findViewById<View>(R.id.toast_layout_root) as ViewGroup
                findViewById<ViewGroup>(R.id.toast_layout_root)
            )
            val text: TextView? = layout.findViewById(R.id.text)
            text?.text = "모양을 바꾼 토스트"
            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER, 0, -100)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
        }

        val button3 = findViewById<View>(R.id.button3) as Button
        button3.setOnClickListener { v -> Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show() }


    }
}