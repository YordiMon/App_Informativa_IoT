package com.yamz.infoiot.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yamz.infoiot.R
import com.yamz.infoiot.WireList
import com.yamz.infoiot.WireListAdapter

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
            HomeList(1, "Arduinos"),
            HomeList(2, "Componentes básicos"),
            HomeList(3, "Componentes avanzados"),
            HomeList(4, "Resistencias"),
            HomeList(5, "Cables"),
        )
    }
}