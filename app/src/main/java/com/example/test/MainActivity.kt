package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<View>(R.id.editText) as EditText

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val name = editText!!.text.toString()
            val intent = Intent(applicationContext, MyService::class.java)
            intent.putExtra("command", "show")
            intent.putExtra("name", name)
            startService(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        processCommand(intent)
        super.onNewIntent(intent)
    }

    fun processCommand(intent: Intent?) {
        if (intent != null) {
            val command = intent.getStringExtra("command")
            val name = intent.getStringExtra("name")
            Toast.makeText(this, "서비스로부터 전달받은 데이터 : $command, $name", Toast.LENGTH_LONG).show()
        }
    }

}