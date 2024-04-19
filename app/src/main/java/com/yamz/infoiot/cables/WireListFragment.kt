package com.yamz.infoiot.cables

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class WireListFragment : Fragment() {

    private var wireList : List<WireList> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_wire_list, container, false)

        initData()

        val recyclerView =
            myView.findViewById<RecyclerView>(
                R.id.WireListRecycler
            )
        val adapter = WireListAdapter(wireList)

        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return myView
    }

    private fun initData() {
        wireList = listOf(
            WireList(
                1,
                "machomacho",
                getString(R.string.maleToMale),
                getString(R.string.maleToMaleDescription),
            ),
            WireList(
                2,
                "machohembra",
                getString(R.string.maleToFemale),
                getString(R.string.maleToFemaleDescription)
            ),
            WireList(
                3,
                "hembrahembra",
                getString(R.string.femaleToFemale),
                getString(R.string.femaleToFemaleDescription)
            ),
            WireList(
                4,
                "puente",
                getString(R.string.jumper),
                getString(R.string.jumperDescription),
            ),
        )
    }
}