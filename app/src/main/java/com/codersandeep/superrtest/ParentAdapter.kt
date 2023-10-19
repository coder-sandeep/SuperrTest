package com.codersandeep.superrtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codersandeep.superrtest.models.Card
import com.codersandeep.superrtest.models.Data
import com.codersandeep.superrtest.utils.Constants
import com.codersandeep.superrtest.utils.PreferenceManager

class ParentAdapter(private val data:List<Data>, private val context: Context) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heading = itemView.findViewById<TextView>(R.id.lesson_type_heading)
        val description = itemView.findViewById<TextView>(R.id.lesson_type_description)

        val rvChild = itemView.findViewById<RecyclerView>(R.id.rv_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.parent_rv_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.heading.text = data[position].heading
        holder.description.text = data[position].description

        val cardIdList = PreferenceManager().getIntArrayFromSharedPreferences(context,Constants.SHARED_PREF_KEY)

        val childAdapter = ChildAdapter(data[position].cards, context, cardIdList)
        holder.rvChild.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.rvChild.adapter = childAdapter
        childAdapter.notifyDataSetChanged()
    }
}