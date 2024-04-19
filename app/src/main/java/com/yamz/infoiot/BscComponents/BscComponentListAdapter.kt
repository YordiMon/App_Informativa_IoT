package com.yamz.infoiot.BscComponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class BscComponentListAdapter(private var bscComponentList: List<BscComponentList>): RecyclerView.Adapter<BscComponentListAdapter.BscComponentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BscComponentViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_wire, parent, false)
        return BscComponentViewHolder(view)
    }

    override fun onBindViewHolder(holder: BscComponentViewHolder, position: Int) {
        val bscComponent = bscComponentList[position]
        holder.render(bscComponent)


        holder.itemView.setOnClickListener {

            val args = Bundle()
            args.putString("bscComponentImg", bscComponent.img)
            args.putString("bscComponentTitle", bscComponent.title)
            args.putString("bscComponentDescription", bscComponent.description)

            it.findNavController().navigate(
                R.id.action_bscComponentListFragment_to_bscComponentDetailFragment, args)
        }
    }

    override fun getItemCount(): Int {
        return bscComponentList.size
    }

    class BscComponentViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)

        fun render(wire: BscComponentList) {
            title.text = wire.title
        }
    }
}