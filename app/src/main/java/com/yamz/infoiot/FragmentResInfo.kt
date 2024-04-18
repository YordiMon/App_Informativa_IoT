package com.yamz.infoiot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import android.widget.Toast
import android.widget.TextView
import android.graphics.Color


class FragmentResInfo : Fragment() {

    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_res_info, container, false)

        val colorSpinner: Spinner = view.findViewById(R.id.colorSpinner)

        val colorsArray = resources.getStringArray(R.array.resistor_colorss)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colorsArray)
        val textView9: TextView = view.findViewById(R.id.textView9)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        colorSpinner.adapter = adapter

        val colorsMap = mapOf(
            "Negro" to "#000000",
            "Marrón" to "#804000",
            "Rojo" to "#FF0000",
            "Naranja" to "#FFA500",
            "Amarillo" to "#FFFF00",
            "Verde" to "#008000",
            "Azul" to "#0000FF",
            "Violeta" to "#800080",
            "Gris" to "#808080",
            "Blanco" to "#FFFFFF"
        )

        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedColorName = colorsMap.keys.toList()[position] // Obtener el nombre del color seleccionado
                val selectedColorHex = colorsMap[selectedColorName]

                if (selectedColorHex != null) {
                    textView9.setTextColor(Color.parseColor(selectedColorHex))
                } else {
                    Toast.makeText(requireContext(), "No se encontró el valor hexadecimal para el color seleccionado", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "Por favor, selecciona un color", Toast.LENGTH_SHORT).show()
            }
        }



        return view
    }


}