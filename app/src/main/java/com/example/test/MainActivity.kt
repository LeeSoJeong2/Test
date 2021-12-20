package com.example.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var adapter: SingerAdapter? = null
    var editText: EditText? = null
    var editText2: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)
        editText2 = findViewById<EditText>(R.id.editText2)
        val listView = findViewById<ListView>(R.id.listView)

        adapter = SingerAdapter()
        adapter!!.addItem(SingerItem("소녀시대", "010-1000-1000", R.drawable.images))
        adapter!!.addItem(SingerItem("걸스데이", "010-2000-2000", R.drawable.images))
        adapter!!.addItem(SingerItem("여자친구", "010-3000-3000", R.drawable.images))
        adapter!!.addItem(SingerItem("티아라", "010-4000-4000", R.drawable.images))
        adapter!!.addItem(SingerItem("애프터스쿨", "010-5000-5000", R.drawable.images))

        listView.adapter = adapter

        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val item = adapter!!.getItem(position) as SingerItem
                Toast.makeText(applicationContext, "선택: " + item.name, Toast.LENGTH_LONG)
                    .show()
            }

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val name = editText!!.getText().toString()
            val mobile = editText2!!.getText().toString()
            adapter!!.addItem(SingerItem(name, mobile, R.drawable.images))
            adapter!!.notifyDataSetChanged()
        }

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