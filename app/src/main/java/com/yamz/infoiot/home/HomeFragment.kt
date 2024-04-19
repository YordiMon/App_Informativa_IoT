package com.yamz.infoiot.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R

class HomeFragment : Fragment() {

    private var elementList : List<HomeList> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_home, container, false)

        initData()

        val recyclerView =
            myView.findViewById<RecyclerView>(
                R.id.homeListRecycler
            )
        val adapter = HomeListAdapter(elementList)

        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return myView
    }

    private fun initData() {
        elementList = listOf(
            HomeList(1, getString(R.string.arduino)),
            HomeList(2, getString(R.string.basic_components)),
            HomeList(3, getString(R.string.advanced_components)),
            HomeList(4, getString(R.string.resistors)),
            HomeList(5, getString(R.string.cableElement)),
        )
    }
}