package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FragmentResistors4 : Fragment(R.layout.fragment_resistors4) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu4 = requireView().findViewById<Button>(R.id.button5)

        menu4.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResistors4_to_fragmentResistors)
        }

    }

}