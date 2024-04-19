package com.yamz.infoiot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController

class ResistorsListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resistors_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val resistors = arrayOf(
            Resistors(
                1,"Resistor de 4 bandas",
                getString(R.string.resistor_4bands),
                R.drawable.band_resistor4
            ),
            Resistors(
                2,"Resistor de 5 bandas",
                getString(R.string.resistor_5bands),
                R.drawable.band_resistor5
            ),
            Resistors(
                3,"Resistor de 6 bandas",
                getString(R.string.resistor_6bands),
                R.drawable.band_resistor6
            ),
            Resistors(
                4,"Código de colores",
                getString(R.string.colorvalue2),
                R.drawable.resistor_color
            )
        )

        val adapter = ResistorsAdapter(resistors) { component ->
            val navController = findNavController()

            val bundle = Bundle()
            bundle.putString(ResistorsDetailFragment.ARG_NAME, component.nombre)
            bundle.putString(ResistorsDetailFragment.ARG_DESCRIPTION, component.descripcion)

            navController.navigate(R.id., bundle)
        }

        recyclerView.adapter = adapter

        return view
    }

    data class Resistors(val id: Int,val nombre: String, val descripcion: String, val imagenResId: Int?)
}
