package com.example.setupbuilder.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.setupbuilder.R
import com.example.setupbuilder.ViewSetupActivity


class SetupRecyclerAdapter(val cardType: String?) :  RecyclerView.Adapter<SetupRecyclerAdapter.ViewHolder>() {
    //Nome do Setup
    private val ItemTitles = arrayOf("Build barata", "Build cara")
    //Preço
    //Informação 1
    //Informação 2


    inner class ViewHolder(ItemView:View) : RecyclerView.ViewHolder(ItemView) {
        var title : TextView
        var infoOne : TextView
        var card : LinearLayout

        init{
            title = itemView.findViewById(R.id.cardTitle)
            infoOne = itemView.findViewById(R.id.cardInfoOne)
            card = itemView.findViewById(R.id.setupCard)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = ItemTitles[position]
        holder.infoOne.text = "Tipo: " + cardType

        holder.card.setOnClickListener {
            val intent = Intent(it.context, ViewSetupActivity::class.java)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return ItemTitles.size
    }

}