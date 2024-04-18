import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.yamz.infoiot.R

class DetailsFago : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_detaill_fago, container, false)

        val nameTextView: TextView = view.findViewById(R.id.componentNameTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)

        nameTextView.text = name
        descriptionTextView.text = description

        return view
    }
}
