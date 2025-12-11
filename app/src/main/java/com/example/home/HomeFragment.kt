package com.example.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.OrderAdapter
import com.example.adapter.PromoAdapter
import com.example.model.Order
import com.example.model.Promo
import com.example.mojek.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Setup Orders RecyclerView
        val rvOrders = view.findViewById<RecyclerView>(R.id.rvOrders)
        rvOrders.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val orderList = listOf(
            Order("Lorem Ipsum", "PNM", "PNM", "Rp10.000", R.drawable.ic_motorcycle),
            Order("Lorem Ipsum", "PNM", "PNM", "Rp20.000", R.drawable.ic_car),
            Order("Lorem Ipsum", "PNM", "PNM", "Rp15.000", R.drawable.ic_motorcycle)
        )
        rvOrders.adapter = OrderAdapter(orderList)

        // Setup Promos RecyclerView
        val rvPromos = view.findViewById<RecyclerView>(R.id.rvPromos)
        rvPromos.layoutManager = LinearLayoutManager(context)
        val promoList = listOf(
            Promo("Lorem Ipsum Dolor Amet", Color.parseColor("#e0e0e0")),
            Promo("Lorem Ipsum Dolor Amet", Color.parseColor("#e0e0e0")),
            Promo("Lorem Ipsum Dolor Amet", Color.parseColor("#e0e0e0"))
        )
        rvPromos.adapter = PromoAdapter(promoList)

        // Setup Booking Button
        val btnOrder = view.findViewById<Button>(R.id.order_button)
        btnOrder.setOnClickListener {
            // Check if action exists in nav_graph, otherwise crash could happen if not compiled yet.
            // But we added it.
            findNavController().navigate(R.id.action_homeFragment_to_bookingFragment)
        }

        return view
    }
}