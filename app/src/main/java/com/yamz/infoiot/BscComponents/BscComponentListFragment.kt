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
                "machomacho",
                getString(R.string.maleToMale),
                getString(R.string.maleToMaleDescription),
            ),
            BscComponentList(
                2,
                "machohembra",
                getString(R.string.maleToFemale),
                getString(R.string.maleToFemaleDescription)
            ),
            BscComponentList(
                3,
                "hembrahembra",
                getString(R.string.femaleToFemale),
                getString(R.string.femaleToFemaleDescription)
            ),
            BscComponentList(
                4,
                "puente",
                getString(R.string.jumper),
                getString(R.string.jumperDescription),
            ),
        )
    }
}