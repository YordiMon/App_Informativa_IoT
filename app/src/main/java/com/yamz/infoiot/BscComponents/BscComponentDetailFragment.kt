package com.yamz.infoiot.BscComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.yamz.infoiot.R

class BscComponentDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val myView = inflater.inflate(R.layout.fragment_bsc_component_detail, container, false)

        val bscComponentImg = arguments?.getString("bscComponentImg")
        val bscComponentTitle = arguments?.getString("bscComponentTitle")
        val bscComponentDescription = arguments?.getString("bscComponentDescription")

        val id = myView.resources.getIdentifier(bscComponentImg, "drawable", context?.packageName)

        val imageView = myView.findViewById<ImageView>(R.id.image)
        imageView.setImageResource(id)

        val title = myView.findViewById<TextView>(R.id.title)
        val description = myView.findViewById<TextView>(R.id.description)

        title.text = bscComponentTitle ?: "Titulo no disponible"
        description.text =  bscComponentDescription ?: "Descripción no disponible"

        return myView
    }
}