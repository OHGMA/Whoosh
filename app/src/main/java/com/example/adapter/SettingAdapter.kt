package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mojek.R
import com.example.model.Setting

class SettingAdapter(private val items: List<Setting>) :
    RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {

    class SettingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvSettingName)
        val swToggle: SwitchCompat = view.findViewById(R.id.switchSetting)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_setting, parent, false)
        return SettingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = item.title
        holder.swToggle.isChecked = item.isEnabled

        // Contoh handle klik (bisa dikembangkan nanti)
        holder.swToggle.setOnCheckedChangeListener { _, isChecked ->
            item.isEnabled = isChecked
            // Di sini nanti kita simpan preference user
        }
    }

    override fun getItemCount() = items.size
}