package com.example.test

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton


class BitmapButton : AppCompatButton {
    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        setBackgroundResource(R.drawable.title_bitmap_button_normal)
        val textSize = resources.getDimension(R.dimen.text_size)
        setTextSize(textSize)
        setTextColor(Color.WHITE)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        when (action) {
            MotionEvent.ACTION_DOWN -> setBackgroundResource(R.drawable.title_bitmap_button_clicked)
            MotionEvent.ACTION_UP -> setBackgroundResource(R.drawable.title_bitmap_button_normal)
        }
        invalidate()
        return true
    }
}

