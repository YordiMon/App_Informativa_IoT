package com.yamz.infoiot.AdvComponents

import DetailsFago
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R
import com.yamz.infoiot.cables.IotComponentAdapter

class AdvComponents : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adv_components, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val temperatureSensorTitle = getString(R.string.temperature_sensor_title)
        val temperatureSensorDescription = getString(R.string.temperature_sensor_description)

        val iotComponents = arrayOf(
            IotComponent(temperatureSensorTitle, temperatureSensorDescription),
            IotComponent(getString(R.string.humidity_sensor_title), getString(R.string.humidity_sensor_description)),
            IotComponent(getString(R.string.light_actuator_title), getString(R.string.light_actuator_description)),
            IotComponent(getString(R.string.ip_camera_title), getString(R.string.ip_camera_description)),
            IotComponent(getString(R.string.door_controller_title), getString(R.string.door_controller_description))
        )

        val adapter = IotComponentAdapter(iotComponents) { component ->
            val navController = findNavController()

            val bundle = Bundle()
            bundle.putString(DetailsFago.ARG_NAME, component.name)
            bundle.putString(DetailsFago.ARG_DESCRIPTION, component.description)

            navController.navigate(R.id.action_advComponents_to_detailsFago, bundle)

        }

        recyclerView.adapter = adapter

        return view
    }

    data class IotComponent(val name: String, val description: String)
}