package com.yamz.infoiot.cables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class WireListAdapter(private var wireList: List<WireList>): RecyclerView.Adapter<WireListAdapter.WireViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WireViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_wire, parent, false)
        return WireViewHolder(view)
    }

    override fun onBindViewHolder(holder: WireViewHolder, position: Int) {
        val wire = wireList[position]
        holder.render(wire)


        holder.itemView.setOnClickListener {

            val args = Bundle()
            args.putString("wireImg", wire.img)
            args.putString("wireTitle", wire.title)
            args.putString("wireDescription", wire.description)

            it.findNavController().navigate(
                R.id.action_wireListFragment_to_wireDetailFragment, args)
        }
    }

    override fun getItemCount(): Int {
        return wireList.size
    }

    class WireViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)

        fun render(wire: WireList) {
            title.text = wire.title
        }
    }
}