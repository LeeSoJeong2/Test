package com.example.test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {
    var callback: FragmentCallback? = null
    var textView: TextView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentCallback) {
            callback = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (callback != null) {
            callback = null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment1, container, false) as ViewGroup
        textView = rootView.findViewById<View>(R.id.textView) as TextView

        val button = rootView.findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            if (callback != null) {
                callback!!.onCommand("show", "프래그먼트1에서 전달함.")
            }
        }
        return rootView
    }

    fun onCommandFromActivity(command: String?, data: String?) {
        textView!!.text = data
    }


}
