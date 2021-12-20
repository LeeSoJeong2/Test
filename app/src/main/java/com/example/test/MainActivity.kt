package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class SingerAdapter : BaseAdapter() {
        var items = ArrayList<SingerItem>()
        override fun getCount(): Int {
            return items.size
        }

        fun addItem(item: SingerItem) {
            items.add(item)
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            var view: SingerItemView? = null
            view = if (convertView == null) {
                SingerItemView(parent.context)
            } else {
                convertView as SingerItemView?
            }

            val item = items[position]
            view?.setName(item.name)
            view?.setMobile(item.mobile)
            view?.setImage(item.resId)

            return view
        }
    }
}