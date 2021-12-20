package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    var items = arrayOf("소녀시대", "걸스데이", "티아라", "여자친구")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<View>(R.id.textView) as TextView

        val spinner = findViewById<Spinner>(R.id.spinner)

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, items
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                textView!!.text = items[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                textView!!.text = "선택 : "
            }
        }
    }
}