package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FragmentResistorsColors : Fragment(R.layout.fragment_resistors_colors) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuC = requireView().findViewById<Button>(R.id.button5)

        menuC.setOnClickListener {

            findNavController().navigate(R.id.action_fragmentResistorsColors_to_fragmentResistors)
        }
    }
}