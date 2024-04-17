import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.yamz.infoiot.AdvComponents

class IotComponentAdapter(context: Context, components: Array<AdvComponents.IotComponent>) :
    ArrayAdapter<AdvComponents.IotComponent>(context, 0, components) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        }

        val component = getItem(position)

        val componentNameTextView: TextView = itemView!!.findViewById(android.R.id.text1)
        componentNameTextView.text = component?.name

        return itemView
    }
}
