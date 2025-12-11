package com.example.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mojek.R

class BookingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        val btnBack = view.findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            // Simulate finding driver
            btnOrder.text = "Mencari Driver..."
            btnOrder.isEnabled = false
            
            val fromLocation = view.findViewById<android.widget.EditText>(R.id.etFrom).text.toString()
            val toLocation = view.findViewById<android.widget.EditText>(R.id.etTo).text.toString()

            Handler(Looper.getMainLooper()).postDelayed({
                // Navigate to Trip
                if (isAdded) {
                   Toast.makeText(context, "Driver Ditemukan!", Toast.LENGTH_SHORT).show()
                   
                   val bundle = Bundle()
                   bundle.putString("from", fromLocation)
                   bundle.putString("to", toLocation)
                   
                   findNavController().navigate(R.id.action_bookingFragment_to_tripFragment, bundle)
                }
            }, 2000)
        }

        return view
    }
}
