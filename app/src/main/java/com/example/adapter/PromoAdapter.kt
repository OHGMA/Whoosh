package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Promo
import com.example.mojek.R

class PromoAdapter(private val promoList: List<Promo>) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    class PromoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPromo: ImageView = itemView.findViewById(R.id.imgPromo)
        val tvTitle: TextView = itemView.findViewById(R.id.tvPromoTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_promo, parent, false)
        return PromoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        val promo = promoList[position]
        holder.tvTitle.text = promo.title
        // In a real app we would load image from URL or Res ID.
        // For now, we set a background color or placeholder if available
        holder.imgPromo.setBackgroundColor(promo.imageColor)
    }

    override fun getItemCount(): Int {
        return promoList.size
    }
}
