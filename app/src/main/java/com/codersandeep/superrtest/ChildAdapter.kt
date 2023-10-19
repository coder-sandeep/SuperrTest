package com.codersandeep.superrtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.codersandeep.superrtest.models.Card
import com.squareup.picasso.Picasso


class ChildAdapter(private val cardsList:List<Card>, private val context: Context, private val completed: IntArray) : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener (this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION && cardsList[position].url.isNotEmpty()){
                (context as Activity).finish()
                val intent = Intent(context,LessonActivity::class.java)
                intent.putExtra("URL",cardsList[position].url)
                intent.putExtra("cardId",cardsList[position].id)
                context.startActivity(intent)
            }
            else
                Toast.makeText(context,"No URL specified",Toast.LENGTH_LONG).show()

        }

        val cardBack = itemView.findViewById<ImageView>(R.id.card_background)
        val cardText = itemView.findViewById<TextView>(R.id.rv_child_lesson_name)
        val tickImage = itemView.findViewById<ImageView>(R.id.tick_lesson_completed)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.child_rv_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardText.text = cardsList[position].text
        holder.cardText.setTextColor(Color.parseColor(cardsList[position].color))

        for(id in completed)
            if(id == cardsList[position].id)
                holder.tickImage.visibility  = View.VISIBLE

        Picasso.get()
            .load(cardsList[position].background)
            .into(holder.cardBack)
    }
}