package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var ratingBar: RatingBar? = null
    var outputView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratingBar = findViewById<View>(R.id.ratingBar) as RatingBar
        outputView = findViewById<View>(R.id.outputView) as TextView

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { showCommentWriteActivity() }
    }

    fun showCommentWriteActivity() {
        val rating = ratingBar!!.rating
        val intent = Intent(applicationContext, CommentWriteActivity::class.java)
        intent.putExtra("rating", rating)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 101) {
            if (intent != null) {
                val contents = intent.getStringExtra("contents")
                outputView!!.text = contents
            }
        }
    }


}