package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var pager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById<View>(R.id.pager) as ViewPager
        pager!!.offscreenPageLimit = 3

        val adapter = MoviePagerAdapter(supportFragmentManager)

        val fragment1 = Fragment1()
        adapter.addItem(fragment1)

        val fragment2 = Fragment2()
        adapter.addItem(fragment2)

        val fragment3 = Fragment3()
        adapter.addItem(fragment3)

        pager!!.adapter = adapter

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { pager!!.currentItem = 1 }
    }

    internal class MoviePagerAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm) {
        var items = ArrayList<Fragment>()
        fun addItem(item: Fragment) {
            items.add(item)
        }

        override fun getItem(position: Int): Fragment {
            return items[position]
        }

        override fun getCount(): Int {
            return items.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "페이지 $position"
        }
    }

}