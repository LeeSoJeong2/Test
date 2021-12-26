package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SmsActivity : AppCompatActivity() {
    var editText: EditText? = null
    var editText2: EditText? = null
    var editText3: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        editText = findViewById<View>(R.id.editText) as EditText
        editText2 = findViewById<View>(R.id.editText2) as EditText
        editText3 = findViewById<View>(R.id.editText3) as EditText

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { finish() }

        val passedIntent = intent
        processCommand(passedIntent)
    }

    override fun onNewIntent(intent: Intent?) {
        processCommand(intent)
        super.onNewIntent(intent)
    }

    private fun processCommand(intent: Intent?) {
        if (intent != null) {
            val sender = intent.getStringExtra("sender")
            val contents = intent.getStringExtra("contents")
            val receivedDate = intent.getStringExtra("receivedDate")
            editText!!.setText(sender)
            editText3!!.setText(contents)
            editText2!!.setText(receivedDate)
        }
    }
}