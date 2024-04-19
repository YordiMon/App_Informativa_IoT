package com.yamz.infoiot.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class HomeListAdapter(private var homeList: List<HomeList>): RecyclerView.Adapter<HomeListAdapter.ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_wire, parent, false)
        return ElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val element = homeList[position]
        holder.render(element)


        holder.itemView.setOnClickListener {

            when (element.id) {
                1 -> {
                    it.findNavController().navigate(
                        R.id.action_homeFragment_to_arduinoListFragment)
                }
                2 -> {
                    it.findNavController().navigate(
                        R.id.action_homeFragment_to_bscComponentListFragment)
                }
                3 -> {
                    it.findNavController().navigate(
                        R.id.action_homeFragment_to_advComponents)
                }
                4 -> {
                    // No ha terminado
                }
                5 -> {
                    it.findNavController().navigate(
                        R.id.action_homeFragment_to_wireListFragment)
                }
                else -> {
                    Log.d("Error", "No ha seleccionado ninguna opcion.")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    class ElementViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)

        fun render(home: HomeList) {
            title.text = home.element
        }
    }
}