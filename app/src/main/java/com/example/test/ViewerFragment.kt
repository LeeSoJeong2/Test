package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ViewerFragment : Fragment() {
    var imageView: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_viewer, container, false) as ViewGroup
        imageView = rootView.findViewById<View>(R.id.imageView) as ImageView
        return rootView
    }

    fun setImage(index: Int) {
        if (index == 0) {
            imageView!!.setImageResource(R.drawable.dream01)
        } else if (index == 1) {
            imageView!!.setImageResource(R.drawable.dream02)
        } else if (index == 2) {
            imageView!!.setImageResource(R.drawable.dream03)
        }
    }
}