package com.yamz.infoiot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.Serializable

class DetaillFago : Fragment() {
    companion object {
        const val ARG_COMPONENT = "component"
    }

    private lateinit var component: AdvComponents.IotComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            component = it.getSerializable(ARG_COMPONENT) as AdvComponents.IotComponent
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detaill_fago, container, false)

        val textView: TextView = view.findViewById(R.id.detailTextView)
        val detailTextView: TextView = view.findViewById(R.id.detailDescriptionTextView)

        textView.text = component.name
        detailTextView.text = component.description

        return view
    }
}
