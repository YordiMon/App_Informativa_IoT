<<<<<<< HEAD:app/src/main/java/com/yamz/infoiot/IotComponentAdapter.kt
package com.yamz.infoiot.cables

import android.os.Bundle
=======
package com.yamz.infoiot.AdvComponents

>>>>>>> ed917e0990addc0a0e2015e66e058c8cb8a32154:app/src/main/java/com/yamz/infoiot/AdvComponents/IotComponentAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class IotComponentAdapter(
    private val components: Array<AdvComponents.IotComponent>,
    private val onItemClick: (AdvComponents.IotComponent) -> Unit
) : RecyclerView.Adapter<IotComponentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.item_wire, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val component = components[position]
        holder.render(component)

        holder.itemView.setOnClickListener {
            onItemClick(component)
        }
    }

    override fun getItemCount(): Int = components.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.title) // Asegúrate de que item_wire tenga un TextView con el id "title"

        fun render(component: AdvComponents.IotComponent) {
            title.text = component.name
        }
    }
}
