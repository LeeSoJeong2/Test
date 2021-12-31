package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    var fragment1: Fragment1? = null
    var fragment2: Fragment2? = null
    var fragment3: Fragment3? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        fragment1 = Fragment1()
        fragment2 = Fragment2()
        fragment3 = Fragment3()

        supportFragmentManager.beginTransaction().add(R.id.container, fragment1!!).commit()

        val tabs = findViewById<View>(R.id.tabs) as TabLayout
        tabs.addTab(tabs.newTab().setText("친구"))
        tabs.addTab(tabs.newTab().setText("일대일채팅"))
        tabs.addTab(tabs.newTab().setText("기타"))

        tabs.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                var selected: Fragment? = null
                if (position == 0) {
                    selected = fragment1
                } else if (position == 1) {
                    selected = fragment2
                } else if (position == 2) {
                    selected = fragment3
                }
                supportFragmentManager.beginTransaction().replace(R.id.container, selected!!)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}