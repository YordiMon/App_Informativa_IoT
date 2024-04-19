package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class FragmentResistors6 : Fragment(R.layout.fragment_resistors6) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu5 = requireView().findViewById<Button>(R.id.button5)


        menu5.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResistors6_to_fragmentResistors)
        }

    }

}