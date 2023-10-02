package com.chandan.carser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class TypeAdap(private val typelist: ArrayList<Model>) : RecyclerView.Adapter<TypeAdap.MyViewHolder>(){

    private lateinit var mListner : onItemCliclListner

    interface onItemCliclListner{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onItemCliclListner){

        mListner = listner

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cartype,
            parent,false)
        return MyViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = typelist[position]
        holder.titleImg.setImageResource(currentItem.ImageTitle)
        holder.tvHeading.text =  currentItem.Heading

    }

    override fun getItemCount(): Int {
        return typelist.size
    }


    class MyViewHolder(itemView: View, listner: onItemCliclListner) : RecyclerView.ViewHolder(itemView)
    {

    val titleImg : ShapeableImageView = itemView.findViewById(R.id.title_image)
    val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

        init {
            itemView.setOnClickListener {

                listner.onItemClick(adapterPosition)

            }
        }


    }


}