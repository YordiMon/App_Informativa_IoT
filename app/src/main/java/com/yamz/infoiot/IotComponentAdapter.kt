import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.yamz.infoiot.R

class IotComponentAdapter(
    private val items: Array<AdvComponents.IotComponent>,
    private val onItemClick: (AdvComponents.IotComponent) -> Unit
) : RecyclerView.Adapter<IotComponentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_iot_component, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.componentNameTextView)

        fun bind(item: AdvComponents.IotComponent) {
            nameTextView.text = item.name
        }
    }
}
