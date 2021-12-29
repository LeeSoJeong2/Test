package com.example.test

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar

class CommentWriteActivity : AppCompatActivity() {
    var ratingBar: RatingBar? = null
    var contentsInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_write)

        ratingBar = findViewById<View>(R.id.ratingBar) as RatingBar
        contentsInput = findViewById<View>(R.id.contentsInput) as EditText

        val saveButton = findViewById<View>(R.id.saveButton) as Button
        saveButton.setOnClickListener { returnToMain() }

        val intent = intent
        processIntent(intent)
    }

    private fun processIntent(intent: Intent?) {
        if (intent != null) {
            val rating = intent.getFloatExtra("rating", 0.0f)
            ratingBar!!.rating = rating
        }
    }

    fun returnToMain() {
        val contents = contentsInput!!.text.toString()
        val intent = Intent()
        intent.putExtra("contents", contents)
        setResult(RESULT_OK, intent)
        finish()
    }

}