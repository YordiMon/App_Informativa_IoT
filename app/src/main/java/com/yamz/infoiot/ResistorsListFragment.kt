package com.yamz.infoiot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class ResistorsListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resistors_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val resistors = listOf(
                Resistors("Resistor de 4 bandas", getString(R.string.resistor_4bands)),
                Resistors("Resistor de 5 bandas", getString(R.string.resistor_5bands)),
                Resistors("Resistor de 6 bandas", getString(R.string.resistor_6bands)),
                Resistors("Código de colores", getString(R.string.colorvalue2))
        )

        val adapter = ResistorsAdapter(resistors) { resistor ->
            val navController = findNavController()

            val bundle = Bundle()
            bundle.putString(DetailsResistorFragment.ARG_NAME, resistor.name)
            bundle.putString(DetailsResistorFragment.ARG_DESCRIPTION, resistor.description)

            navController.navigate(R.id.action_resistorsListFragment_to_resistorsDetailFragment, bundle)

        }

        recyclerView.adapter = adapter
        return view
    }

    data class Resistors(val name: String, val description: String)
}
