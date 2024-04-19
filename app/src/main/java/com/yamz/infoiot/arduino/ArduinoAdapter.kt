package com.yamz.infoiot.arduino

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class ArduinoAdapter(
    private var items: List<ArduinoListFragment.Arduinos>,
    private val onItemClick: (ArduinoListFragment.Arduinos) -> Unit
) : RecyclerView.Adapter<ArduinoAdapter.ViewHolder>() {

    private var filteredItems: List<ArduinoListFragment.Arduinos> = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_arduino, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredItems[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = filteredItems.size

    fun filterList(filteredList: List<ArduinoListFragment.Arduinos>) {
        filteredItems = filteredList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(item: ArduinoListFragment.Arduinos) {
            nameTextView.text = item.nombre
        }
    }
}
