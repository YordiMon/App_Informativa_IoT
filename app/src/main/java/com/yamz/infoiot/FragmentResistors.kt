package com.yamz.infoiot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class FragmentResistors : Fragment(R.layout.fragment_res) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn14 = requireView().findViewById<Button>(R.id.button)
        val btn15 = requireView().findViewById<Button>(R.id.button2)
        val btn16 = requireView().findViewById<Button>(R.id.button3)
        val btn1c = requireView().findViewById<Button>(R.id.button4)


        btn14.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResistors_to_fragmentResistors4)
        }
        btn15.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentResistors_to_fragmentResistor5)
        }

        btn16.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResistors_to_fragmentResistors6)
        }

        btn1c.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResistors_to_fragmentResistorsColors)
        }


    }

}