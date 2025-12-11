package com.example.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mojek.R

class TripFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_trip, container, false)
        
        val btnMessage = view.findViewById<Button>(R.id.btnMessage)
        val btnFinish = view.findViewById<Button>(R.id.btnFinish)
        val actionContainerOnTrip = view.findViewById<LinearLayout>(R.id.actionContainerOnTrip)
        val tvRouteFrom = view.findViewById<TextView>(R.id.tvRouteFrom)
        val tvRouteTo = view.findViewById<TextView>(R.id.tvRouteTo)

        val fromLocation = arguments?.getString("from") ?: "Lokasi Jemput"
        val toLocation = arguments?.getString("to") ?: "Tujuan"

        tvRouteFrom.text = fromLocation
        tvRouteTo.text = toLocation

        btnMessage.setOnClickListener {
            findNavController().navigate(R.id.action_tripFragment_to_chatDetailFragment)
        }
        
        btnFinish.setOnClickListener {
            val newOrder = com.example.model.Order(
                "Ke $toLocation", 
                fromLocation, 
                toLocation, 
                "Rp15.000", 
                com.example.mojek.R.drawable.ic_motorcycle
            )

            com.example.model.OrderRepository.addOrder(newOrder)

            findNavController().navigate(R.id.action_tripFragment_to_homeFragment)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) {
                // Trip Finished State
                actionContainerOnTrip.visibility = View.GONE
                btnFinish.visibility = View.VISIBLE
                btnFinish.isEnabled = true
                
                Toast.makeText(context, "Perjalanan Selesai", Toast.LENGTH_SHORT).show()
            }
        }, 5000)

        return view
    }
}
