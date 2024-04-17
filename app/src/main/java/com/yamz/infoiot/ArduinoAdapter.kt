import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.Arduinos
import com.yamz.infoiot.R

class ArduinoAdapter(private val arduinos: List<Arduinos>, private val listener: OnArduinoClickListener) :
    RecyclerView.Adapter<ArduinoAdapter.ArduinoViewHolder>() {

    interface OnArduinoClickListener {
        fun onArduinoClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArduinoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_arduino, parent, false)
        return ArduinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArduinoViewHolder, position: Int) {
        val arduino = arduinos[position]
        holder.bind(arduino)
    }

    override fun getItemCount(): Int {
        return arduinos.size
    }

    inner class ArduinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val nameTextView: TextView = itemView.findViewById(R.id.textview_arduino_name)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(arduino: Arduinos) {
            nameTextView.text = arduino.nombre
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onArduinoClick(position)
            }
        }
    }
}
