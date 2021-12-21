package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var likeButton: Button? = null
    var likeCountView: TextView? = null

    var likeCount = 1
    var likeState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        likeButton = findViewById<View>(R.id.likeButton) as Button
        likeButton!!.setOnClickListener {
            if (likeState) {
                decrLikeCount()
            } else {
                incrLikeCount()
            }
            likeState = !likeState
        }

        likeCountView = findViewById<View>(R.id.likeCountView) as TextView
        val listView = findViewById<View>(R.id.listView) as ListView
    }

    fun incrLikeCount() {
        likeCount += 1
        likeCountView!!.text = likeCount.toString()
        likeButton!!.setBackgroundResource(R.drawable.ic_thumb_up_selected)
    }

    fun decrLikeCount() {
        likeCount -= 1
        likeCountView!!.text = likeCount.toString()
        likeButton!!.setBackgroundResource(R.drawable.ic_thumb_up)
    }
}