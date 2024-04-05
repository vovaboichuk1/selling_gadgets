package com.cricoo.selling_gadgets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaptopAdapter(private val laptops: List<Laptop>) : RecyclerView.Adapter<LaptopAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val laptop = laptops[position]
                    val popup = LaptopPopup(itemView.context, laptop)
                    popup.show(itemView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.laptop_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val laptop = laptops[position]
        holder.textViewName.text = laptop.name

        holder.itemView.setOnClickListener {
            val popup = LaptopPopup(holder.itemView.context, laptop)
            popup.show(holder.itemView)
        }
    }

    override fun getItemCount(): Int {
        return laptops.size
    }
}





