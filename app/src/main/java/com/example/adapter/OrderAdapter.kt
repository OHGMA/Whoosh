package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Order
import com.example.mojek.R

class OrderAdapter(private val orderList: List<Order>) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcon: ImageView = itemView.findViewById(R.id.imgOrderIcon)
        val tvTitle: TextView = itemView.findViewById(R.id.tvOrderTitle)
        val tvFrom: TextView = itemView.findViewById(R.id.tvOrderFrom)
        val tvTo: TextView = itemView.findViewById(R.id.tvOrderTo)
        val tvPrice: TextView = itemView.findViewById(R.id.tvOrderPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_home, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderList[position]
        holder.tvTitle.text = order.title
        holder.tvFrom.text = "From: ${order.from}"
        holder.tvTo.text = "To: ${order.to}"
        holder.tvPrice.text = order.price
        holder.imgIcon.setImageResource(order.iconRes)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}
