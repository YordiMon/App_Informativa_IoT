package com.yamz.infoiot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class ResistorsAdapter(
        private val resistors: List<ResistorsListFragment.Resistors>,
        private val onItemClick: (ResistorsListFragment.Resistors) -> Unit
) : RecyclerView.Adapter<ResistorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_resistors, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resistor = resistors[position]
        holder.bind(resistor)
        holder.itemView.setOnClickListener { onItemClick(resistor) }
    }

    override fun getItemCount(): Int = resistors.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(resistor: ResistorsListFragment.Resistors) {
            nameTextView.text = resistor.name
        }
    }
}
