package com.example.test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<View>(R.id.editText) as EditText

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val receiver = editText!!.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$receiver"))
            startActivity(intent)
        }
    }
}