package com.yamz.infoiot.BscComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R
import com.yamz.infoiot.cables.WireList
import com.yamz.infoiot.cables.WireListAdapter

class BscComponentListFragment : Fragment() {

    private var bscComponentList : List<BscComponentList> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_bsc_component_list, container, false)

        initData()

        val recyclerView =
            myView.findViewById<RecyclerView>(
                R.id.BscComponentListRecycler
            )

        val adapter = BscComponentListAdapter(bscComponentList)

        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return myView
    }

    private fun initData() {
        bscComponentList = listOf(
            BscComponentList(
                1,
                "lcd",
                getString(R.string.lcd_display_title),
                getString(R.string.lcd_display_description),
            ),
            BscComponentList(
                2,
                "sensordemovimiento",
                getString(R.string.motion_sensor_title),
                getString(R.string.motion_sensor_description)
            ),
            BscComponentList(
                3,
                "fotorresistencia",
                getString(R.string.ldr_title),
                getString(R.string.ldr_description)
            ),
            BscComponentList(
                4,
                "led",
                getString(R.string.led_title),
                getString(R.string.led_description),
            ),
            BscComponentList(
                5,
                "buzzer",
                getString(R.string.buzzer_title),
                getString(R.string.buzzer_description),
            ),
            BscComponentList(
                6,
                "detectorluzoscuridad",
                getString(R.string.light_dark_sensor_title),
                getString(R.string.light_dark_sensor_description),
            ),
            BscComponentList(
                7,
                "sensorultrasonico",
                getString(R.string.ultrasonic_sensor_title),
                getString(R.string.ultrasonic_sensor_description),
            ),
        )
    }
}