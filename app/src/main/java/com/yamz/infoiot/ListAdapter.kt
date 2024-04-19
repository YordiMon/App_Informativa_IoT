package com.yamz.infoiot
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
class ListAdapter {


    class WireListAdapter(private var ListBasicosFragment: List<ListBasicosFragment>): RecyclerView.Adapter<WireListAdapter.WireViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WireViewHolder {

            val inflador = LayoutInflater.from(parent.context)

            val view = inflador.inflate(R.layout.item_wire, parent, false)
            return WireViewHolder(view)
        }

        override fun onBindViewHolder(holder: WireViewHolder, position: Int) {
            val wire = ListBasicosFragmentt[position]
            holder.render(wire)


            holder.itemView.setOnClickListener {

                val args = Bundle()
                args.putString("ListImg", List.img)
                args.putString("ListTitle", List.title)
                args.putString("ListDescription", List.description)

                it.findNavController().navigate(
                    R.id.action_ListFragment_to_ListDetailFragment, args)
            }
        }

        override fun getItemCount(): Int {
            return ListBasicosFragment.size
        }

        class WireViewHolder(view: View): RecyclerView.ViewHolder(view) {

            val title: TextView = view.findViewById(R.id.title)

            fun render(wire: ListBasicosFragment) {
                title.text = List.title
            }
        }
    }
}