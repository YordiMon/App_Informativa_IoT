package com.yamz.infoiot.Resistors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.yamz.infoiot.R

class ResisitorsDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val myView = inflater.inflate(R.layout.fragment_resisitors_detail, container, false)

        val resistorImg = arguments?.getString("resistorImg")
        val resistorTitle = arguments?.getString("resistorTitle")
        val resistorDescription = arguments?.getString("resistorDescription")

        val id = myView.resources.getIdentifier(resistorImg, "drawable", context?.packageName)

        val imageView = myView.findViewById<ImageView>(R.id.image)
        imageView.setImageResource(id)

        val title = myView.findViewById<TextView>(R.id.title)
        val description = myView.findViewById<TextView>(R.id.description)

        title.text = resistorTitle ?: "Titulo no disponible"
        description.text =  resistorDescription ?: "Descripción no disponible"

        return myView
    }
}