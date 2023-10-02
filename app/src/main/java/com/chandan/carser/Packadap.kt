package com.chandan.carser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Packadap(private val typelist: ArrayList<Packs>) : RecyclerView.Adapter<Packadap.MyViewHolder>() {

    private lateinit var mlistner : onItemClickListner

    interface onItemClickListner{

        fun onItemClicked(position: Int)

    }

    fun itemClicklistner(listner: onItemClickListner){

        mlistner = listner

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Packadap.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pack_item,
            parent,false)
        return Packadap.MyViewHolder(itemView,mlistner)
    }

    override fun onBindViewHolder(holder: Packadap.MyViewHolder, position: Int) {
        val currentItem = typelist[position]
       holder.Packhead.text = currentItem.packs
    }

    override fun getItemCount(): Int {
        return typelist.size
    }

    class MyViewHolder(itemView : View,listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {


        val Packhead: TextView = itemView.findViewById(R.id.Packhead)

        init {

            itemView.setOnClickListener {

                listner.onItemClicked(adapterPosition)

            }

        }

    }
}