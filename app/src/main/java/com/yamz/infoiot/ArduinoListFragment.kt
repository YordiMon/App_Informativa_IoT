package com.yamz.infoiot
import ArduinoAdapter
import ArduinoDetailsFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
class ArduinoListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_arduino_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val arduinos = arrayOf(
            Arduinos(
                1,"Arduino Uno",
                getString(R.string.arduino_uno_description),
                R.drawable.arduinouno
            ),
            Arduinos(
                2,"Arduino Mega",
                getString(R.string.arduino_mega_description),
                R.drawable.arduinomega
            ),
            Arduinos(
                3,"Arduino Nano",
                getString(R.string.arduino_nano_description),
                R.drawable.arduinonano
            ),
            Arduinos(
                4,"Arduino Leonardo",
                getString(R.string.arduino_leonardo_description),
                R.drawable.arduinoleonardo
            ),
            Arduinos(
                5,"Arduino Due",
                getString(R.string.arduino_due_description),
                R.drawable.arduinodue
            ),
            Arduinos(
                6,"Arduino Pro Mini",
                getString(R.string.arduino_pro_mini_description),
                R.drawable.arduinomini
            ),
            Arduinos(
                7,"Arduino Pro Micro",
                getString(R.string.arduino_pro_micro_description),
                R.drawable.arduinomicro
            ),
            Arduinos(
                8,"Arduino MKR1000",
                getString(R.string.arduino_mkr1000_description),
                R.drawable.arduinomkr1000
            ),
            Arduinos(
                9,"Arduino MKR Zero",
                getString(R.string.arduino_mkr_zero_description),
                R.drawable.arduinomkrzero
            ),
            Arduinos(
                10,"Arduino MKR FOX 1200",
                getString(R.string.arduino_mkr_fox_1200_description),
                R.drawable.arduinomkrfox1200
            ),
            Arduinos(
                11,"Arduino MKR WAN 1300",
                getString(R.string.arduino_mkr_wan_1300_description),
                R.drawable.arduinowan1300
            ),
            Arduinos(
                12,"Arduino MKR GSM 1400",
                getString(R.string.arduino_mkr_gsm_1400_description),
                R.drawable.arduinomkrgsm1400
            ),
            Arduinos(
                13,"Arduino MKR NB 1500",
                getString(R.string.arduino_mkr_nb_1500_description),
                R.drawable.arduinomkrnb1500
            ),
            Arduinos(
                14,"Arduino MKR VIDOR 4000",
                getString(R.string.arduino_mkr_vidor_4000_description),
                R.drawable.arduinomkrvidor4000
            ),
            Arduinos(
                15,"Arduino Nano 33 IoT",
                getString(R.string.arduino_nano_33_iot_description),
                R.drawable.arduinonano33
            ),
            Arduinos(
                16,"Arduino Nano 33 BLE",
                getString(R.string.arduino_nano_33_ble_description),
                R.drawable.arduinonano33ble
            ),
            Arduinos(
                17,"Arduino Nano 33 BLE Sense",
                getString(R.string.arduino_nano_33_ble_sense_description),
                R.drawable.arduinonano33blesense
            ),
            Arduinos(
                18,"Arduino Nano Every",
                getString(R.string.arduino_nano_every_description),
                R.drawable.arduinonanoevery
            ),
            Arduinos(
                19,"Arduino Nano RP2040 Connect",
                getString(R.string.arduino_nano_rp2040_connect_description),
                R.drawable.arduinonanorp2040connect
            )
        )


        val adapter = ArduinoAdapter(arduinos) { component ->
            val navController = findNavController()

            val bundle = Bundle()
            bundle.putString(ArduinoDetailsFragment.ARG_NAME, component.nombre)
            bundle.putString(ArduinoDetailsFragment.ARG_DESCRIPTION, component.descripcion)

            navController.navigate(R.id.action_arduinoListFragment_to_arduinoDetailsFragment, bundle)
        }

        recyclerView.adapter = adapter

        return view
    }

    data class Arduinos(val id: Int,val nombre: String, val descripcion: String, val imagenResId: Int?)

}