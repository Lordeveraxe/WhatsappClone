package com.uptc.whatsapp.ui.chats.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uptc.whatsapp.R
import com.uptc.whatsapp.ui.chats.items.ChatItem
import com.uptc.whatsapp.ui.chats.holders.ChatViewHolder

class ChatsAdapter(private val chatList: List<ChatItem>) : RecyclerView.Adapter<ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}