package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView!!.layoutManager = layoutManager

        val adapter = SingerAdapter(applicationContext)

        adapter.addItem(SingerItem("소녀시대", "010-1000-1000"))
        adapter.addItem(SingerItem("걸스데이", "010-2000-2000"))
        adapter.addItem(SingerItem("여자친구", "010-3000-3000"))

        recyclerView!!.adapter = adapter
    }
}