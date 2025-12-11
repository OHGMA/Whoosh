package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Message
import com.example.mojek.R

class ChatAdapter(private val messageList: List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ME = 1
    private val VIEW_TYPE_OTHER = 2

    class MeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMessage: TextView = itemView.findViewById(R.id.tvMessageMe)
        val tvTimestamp: TextView = itemView.findViewById(R.id.tvTimestampMe)
    }

    class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMessage: TextView = itemView.findViewById(R.id.tvMessageOther)
        val tvTimestamp: TextView = itemView.findViewById(R.id.tvTimestampOther)
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isMe) VIEW_TYPE_ME else VIEW_TYPE_OTHER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ME) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_me, parent, false)
            MeViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_other, parent, false)
            OtherViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]
        if (holder is MeViewHolder) {
            holder.tvMessage.text = message.text
            holder.tvTimestamp.text = message.timestamp
        } else if (holder is OtherViewHolder) {
            holder.tvMessage.text = message.text
            holder.tvTimestamp.text = message.timestamp
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}
