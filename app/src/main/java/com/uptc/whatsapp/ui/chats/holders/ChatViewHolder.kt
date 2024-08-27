package com.uptc.whatsapp.ui.chats.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uptc.whatsapp.R
import com.uptc.whatsapp.ui.chats.items.ChatItem

class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val chatNameTextView: TextView = itemView.findViewById(R.id.textView_chat_name)
    private val lastMessageTextView: TextView = itemView.findViewById(R.id.textView_last_message)
    private val timestampTextView: TextView = itemView.findViewById(R.id.textView_timestamp)

    fun bind(chat: ChatItem) {
        chatNameTextView.text = chat.name
        lastMessageTextView.text = chat.lastMessage
        timestampTextView.text = chat.timestamp
    }
}
