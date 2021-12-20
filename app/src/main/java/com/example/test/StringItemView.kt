package com.example.test

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class SingerItemView : LinearLayout {
    var textView: TextView? = null
    var textView2: TextView? = null
    var imageView: ImageView? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.singer_item, this, true)
        textView = findViewById<View>(R.id.textView) as TextView
        textView2 = findViewById<View>(R.id.textView2) as TextView
        imageView = findViewById<View>(R.id.imageView) as ImageView
    }

    fun setName(name: String?) {
        textView!!.text = name
    }

    fun setMobile(mobile: String?) {
        textView2!!.text = mobile
    }

    fun setImage(resId: Int) {
        imageView!!.setImageResource(resId)
    }
}
