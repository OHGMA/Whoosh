package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ChatAdapter
import com.example.model.Message
import com.example.mojek.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatDetailFragment : Fragment() {

    private lateinit var chatAdapter: ChatAdapter
    private val messageList = ArrayList<Message>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat_detail, container, false)

        val btnBack = view.findViewById<ImageView>(R.id.btnBackChat)
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val rvChat = view.findViewById<RecyclerView>(R.id.rvChat)
        rvChat.layoutManager = LinearLayoutManager(context)

        if (messageList.isEmpty()) {
            messageList.add(Message("Halo, apakah masih jauh?", true, "10:00"))
            messageList.add(Message("Sudah dekat kak, sebentar lagi sampai.", false, "10:01"))
            messageList.add(Message("Oke, saya tunggu di depan ya.", true, "10:02"))
        }
        
        chatAdapter = ChatAdapter(messageList)
        rvChat.adapter = chatAdapter
        rvChat.scrollToPosition(messageList.size - 1)

        val etMessage = view.findViewById<EditText>(R.id.etMessage)
        val btnSend = view.findViewById<ImageView>(R.id.btnSend)
        
        btnSend.setOnClickListener {
            val text = etMessage.text.toString()
            if (text.isNotEmpty()) {
                val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
                val newMessage = Message(text, true, currentTime)
                messageList.add(newMessage)
                chatAdapter.notifyItemInserted(messageList.size - 1)
                rvChat.smoothScrollToPosition(messageList.size - 1)
                etMessage.text.clear()
            }
        }

        return view
    }
}