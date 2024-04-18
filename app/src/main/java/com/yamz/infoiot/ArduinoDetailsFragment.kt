import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yamz.infoiot.R

class ArduinoDetailsFragment : Fragment() {

    companion object {
        const val ARG_NAME = "name"
        const val ARG_DESCRIPTION = "description"
    }

    private var name: String? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            description = it.getString(ARG_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_arduino_details, container, false)

        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val arduinoImageView: ImageView = view.findViewById(R.id.arduinoImageView)

        nameTextView.text = name ?: ""
        descriptionTextView.text = description ?: ""


        if (name != null) {
            val imageName = name!!.toLowerCase().replace("\\s+".toRegex(), "")
            val imageResource = resources.getIdentifier(imageName, "drawable", requireContext().packageName)
            if (imageResource != 0) {
                arduinoImageView.setImageResource(imageResource)
            } else {
                arduinoImageView.setImageResource(R.drawable.arduinouno)
            }
        } else {
            arduinoImageView.setImageResource(R.drawable.arduinouno)
        }

        return view
    }
}