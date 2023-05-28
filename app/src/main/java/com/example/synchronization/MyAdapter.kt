package com.example.synchronization

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context:Context, private val list:Array<Int>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textView=itemView.findViewById<TextView>(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.model_item,parent,false)
        val paramLayout =
            view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        paramLayout.width = parent.width / 7
        paramLayout.height = parent.height / 5

        return ViewHolder(view)
    }

    override fun getItemCount()=35
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position in list) {
            holder.textView.text=""
            holder.textView.setTextColor(ContextCompat.getColor(context,R.color.green))
            holder.textView.setBackgroundColor(ContextCompat.getColor(context,R.color.green))
        }
    }

}
