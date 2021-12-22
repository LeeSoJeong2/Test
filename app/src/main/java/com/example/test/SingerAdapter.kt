package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SingerAdapter(var context: Context) :
    RecyclerView.Adapter<SingerAdapter.ViewHolder>() {
    var items = ArrayList<SingerItem>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.singer_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    fun addItem(item: SingerItem) {
        items.add(item)
    }

    fun addItems(items: ArrayList<SingerItem>) {
        this.items = items
    }

    fun getItme(position: Int): SingerItem {
        return items[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var textView2: TextView
        fun setItem(item: SingerItem) {
            textView.setText(item.name)
            textView2.setText(item.mobile)
        }

        init {
            textView = itemView.findViewById<View>(R.id.textView3) as TextView
            textView2 = itemView.findViewById<View>(R.id.textView4) as TextView
        }
    }
}
