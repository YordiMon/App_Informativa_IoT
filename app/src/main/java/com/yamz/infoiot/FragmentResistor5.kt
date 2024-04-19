package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FragmentResistor5 : Fragment(R.layout.fragment_resistor5) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu6 = requireView().findViewById<Button>(R.id.button5)


        menu6.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentResistor5_to_fragmentResistors)
        }
    }



}