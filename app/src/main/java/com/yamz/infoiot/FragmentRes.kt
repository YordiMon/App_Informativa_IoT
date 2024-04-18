package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager


class FragmentRes : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_res, container, false)
        val textView4 = view.findViewById<TextView>(R.id.textView4)

        textView4.setOnClickListener {
            val fragmentResInfo = FragmentResInfo()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragment_container, fragmentResInfo)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

}