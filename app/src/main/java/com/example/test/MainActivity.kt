package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    var detector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val view = findViewById<View>(R.id.view)
        view.setOnTouchListener { v, event ->
            val action = event.action
            val curX = event.x
            val curY = event.y
            if (action == MotionEvent.ACTION_DOWN) {
                println("손가락 눌렸음 : ")
            } else if (action == MotionEvent.ACTION_MOVE) {
                println("손가락 움직임 : $curX, $curY")
            } else if (action == MotionEvent.ACTION_UP) {
                println("손가락 떼졌음 : $curX, $curY")
            }
            true
        }

        detector = GestureDetector(this, object : GestureDetector.OnGestureListener {
            override fun onDown(e: MotionEvent): Boolean {
                println("onDown() 호출됨.")
                return true
            }

            override fun onShowPress(e: MotionEvent) {
                println("onShowPress() 호출됨.")
            }

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                println("onSingleTapUp() 호출됨.")
                return true
            }

            override fun onScroll(
                e1: MotionEvent,
                e2: MotionEvent,
                distanceX: Float,
                distanceY: Float
            ): Boolean {
                println("onScroll() 호출됨. : $distanceX, $distanceY")
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                println("onLongPress() 호출됨.")
            }

            override fun onFling(
                e1: MotionEvent,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                println("onFling() 호출됨. : $velocityX, $velocityY")
                return true
            }
        })

        val view2 = findViewById<View>(R.id.view2)
        view2.setOnTouchListener { v, event ->
            detector!!.onTouchEvent(event)
            true
        }
    }

    fun println(data: String) {
        textView!!.append(data + "\n")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "시스템 BACK 버튼 눌림.", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

}