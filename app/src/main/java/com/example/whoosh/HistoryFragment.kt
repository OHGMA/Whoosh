package com.example.whoosh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.mojek.R

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // pastikan nama layout sesuai file di res/layout
        return inflater.inflate(R.layout.activity_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val container = view.findViewById<LinearLayout>(R.id.historyContainer)

        // contoh menambah 3 card
        repeat(3) {
            val card = layoutInflater.inflate(R.layout.item_history, container, false)
            container.addView(card)
        }
    }
}
