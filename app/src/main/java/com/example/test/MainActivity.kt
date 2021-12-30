package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    var fragment1: ListFragment? = null
    var fragment2: ViewerFragment? = null

    var manager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        fragment1 = manager!!.findFragmentById(R.id.listFragment) as ListFragment?
        fragment2 = manager!!.findFragmentById(R.id.viewerFragment) as ViewerFragment?
    }

    fun onImageChange(index: Int) {
        fragment2!!.setImage(index)
    }
}