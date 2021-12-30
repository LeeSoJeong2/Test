package com.example.test

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
    var activity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as MainActivity?
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false) as ViewGroup

        val button = rootView.findViewById<View>(R.id.button) as Button
        button.setOnClickListener { activity!!.onImageChange(0) }

        val button2 = rootView.findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener { activity!!.onImageChange(1) }

        val button3 = rootView.findViewById<View>(R.id.button3) as Button
        button3.setOnClickListener { activity!!.onImageChange(2) }

        return rootView
    }
}