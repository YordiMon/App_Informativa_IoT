package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DetailsBasicosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_wire_detail, container, false)

        val wireImg = arguments?.getString("wireImg")
        val wireTitle = arguments?.getString("wireTitle")
        val wireDescription = arguments?.getString("wireDescription")

        val id = myView.resources.getIdentifier(wireImg, "drawable", context?.packageName)

        val imageView = myView.findViewById<ImageView>(R.id.image)
        imageView.setImageResource(id)

        val title = myView.findViewById<TextView>(R.id.title)
        val description = myView.findViewById<TextView>(R.id.description)

        title.text = wireTitle ?: "Titulo no disponible"
        description.text =  wireDescription ?: "Descripción no disponible"

        return myView
    }
}
    }


    }
