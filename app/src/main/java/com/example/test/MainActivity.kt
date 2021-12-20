package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var adapter: SingerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<View>(R.id.gridView) as GridView

        adapter = SingerAdapter()
        adapter!!.addItem(SingerItem("소녀시대", "010-1000-1000", R.drawable.image))
        adapter!!.addItem(SingerItem("걸스데이", "010-2000-2000", R.drawable.image))
        adapter!!.addItem(SingerItem("여자친구", "010-3000-3000", R.drawable.image))
        adapter!!.addItem(SingerItem("티아라", "010-4000-4000", R.drawable.image))
        adapter!!.addItem(SingerItem("애프터스쿨", "010-5000-5000", R.drawable.image))

        gridView.adapter = adapter

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = adapter!!.getItem(position) as SingerItem
                Toast.makeText(applicationContext, "선택: " + item.name, Toast.LENGTH_LONG)
                    .show()
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