package com.yamz.infoiot.Resistors
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R
import com.yamz.infoiot.Resistors.ResistorsList
import com.yamz.infoiot.cables.WireListAdapter

class ResistorsListFragment : Fragment() {

    private var resistorList : List<ResistorsList> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_resistors_list, container, false)

        initData()

        val recyclerView =
            myView.findViewById<RecyclerView>(
                R.id.ResistorListRecycler
            )
        val adapter = ResistorsListAdapter(resistorList)

        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return myView
    }

    private fun initData() {
        resistorList = listOf(
            ResistorsList(
                1,
                "band_resistor4",
                getString(R.string.resistor_4bands_description),
                getString(R.string.resistor_4bands),
            ),
            ResistorsList(
                2,
                "band_resistor5",
                getString(R.string.resistor_5bands_description),
                getString(R.string.resistor_5bands)
            ),
            ResistorsList(
                3,
                "band_resistor5",
                getString(R.string.resistor_6bands_description),
                getString(R.string.resistor_6bands)
            ),
            ResistorsList(
                4,
                "colorres",
                getString(R.string.colorvalue2_description),
                getString(R.string.colorvalue2),
            ),
        )
    }
}