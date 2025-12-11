package com.example.whoosh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        val rvSettings = view.findViewById<RecyclerView>(R.id.rvSettings)

        // Data Dummy (Nanti bisa diambil dari Database/API)
        val dataSettings = listOf(
            SettingItem("God mode", false),
            SettingItem("Voice", true),
            SettingItem("Vsync", true),
            SettingItem("Frame limit", false),
            SettingItem("Show FPS", false),
            SettingItem("Shadow", true)
        )

        // Setup RecyclerView
        rvSettings.layoutManager = LinearLayoutManager(context)
        rvSettings.adapter = SettingAdapter(dataSettings)

        return view
    }
}