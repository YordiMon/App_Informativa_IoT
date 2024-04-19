package com.yamz.infoiot.Resistors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R
import com.yamz.infoiot.cables.WireList

class ResistorsListAdapter(private var resistorsList: List<ResistorsList>): RecyclerView.Adapter<ResistorsListAdapter.ResistorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResistorsViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_wire, parent, false)
        return ResistorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResistorsViewHolder, position: Int) {
        val resistor = resistorsList[position]
        holder.render(resistor)


        holder.itemView.setOnClickListener {

            val args = Bundle()
            args.putString("resistorImg", resistor.img)
            args.putString("resistorTitle", resistor.title)
            args.putString("resistorDescription", resistor.description)

            it.findNavController().navigate(
                R.id.action_resistorsListFragment2_to_resisitorsDetailFragment, args)
        }
    }

    override fun getItemCount(): Int {
        return resistorsList.size
    }

    class ResistorsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)

        fun render(resisitor: ResistorsList) {
            title.text = resisitor.title
        }
    }
}