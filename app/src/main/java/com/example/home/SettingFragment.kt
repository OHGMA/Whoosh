package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.SettingAdapter
import com.example.model.Setting
import com.example.mojek.R

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        val rvSettings = view.findViewById<RecyclerView>(R.id.rvSettings)

        val dataSettings = listOf(
            Setting("Notifikasi", false),
            Setting("Voice", true),
            Setting("Vsync", true),
            Setting("Frame limit", false),
            Setting("Show FPS", false),
            Setting("Shadow", true)
        )

        // Setup RecyclerView
        rvSettings.layoutManager = LinearLayoutManager(context)
        rvSettings.adapter = SettingAdapter(dataSettings)

        return view
    }
}