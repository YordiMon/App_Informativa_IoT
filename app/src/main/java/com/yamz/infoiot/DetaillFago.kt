import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.ImageView
import com.yamz.infoiot.R

class DetailsFago : Fragment() {
    companion object {
        const val ARG_NAME = "name"
        const val ARG_DESCRIPTION = "description"
    }

    private var name: String? = null
    private var description: String? = null
    private var imageResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            description = it.getString(ARG_DESCRIPTION)
            imageResId = getImageResIdForComponent(name)
        }
    }

    private fun getImageResIdForComponent(name: String?): Int? {
        return when (name) {
            "Sensor de temperatura" -> R.drawable.temperature
            "Sensor de humedad" -> R.drawable.humedad
            "Actuador de luz" -> R.drawable.luces
            "Cámara IP" -> R.drawable.ipcamera
            "Controlador de puerta" -> R.drawable.door
            else -> null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detaill_fago, container, false)
        val nameTextView: TextView = view.findViewById(R.id.componentNameTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val componentImageView: ImageView = view.findViewById(R.id.componentImageView)

        nameTextView.text = name
        descriptionTextView.text = description
        imageResId?.let { componentImageView.setImageResource(it) }

        return view
    }
}