package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ChatListAdapter
import com.example.mojek.R

class ChatListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat_list, container, false)

        val rvChatList = view.findViewById<RecyclerView>(R.id.rvChatList)
        rvChatList.layoutManager = LinearLayoutManager(context)
        
        val adapter = ChatListAdapter {
            // Navigate to Detail on Click
            findNavController().navigate(R.id.action_chatListFragment_to_chatDetailFragment)
        }
        rvChatList.adapter = adapter

        return view
    }
}
