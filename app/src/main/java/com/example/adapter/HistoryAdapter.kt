package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Order
import com.example.mojek.R

class HistoryAdapter(private val historyList: List<Order>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDest: TextView = itemView.findViewById(R.id.tvDestHistory)
        val tvDate: TextView = itemView.findViewById(R.id.tvDateHistory)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPriceHistory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val order = historyList[position]
        holder.tvDest.text = order.to
        holder.tvPrice.text = order.price
        holder.tvDate.text = "10 Des 2023" // Dummy date for now since Order model doesn't have date
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}
