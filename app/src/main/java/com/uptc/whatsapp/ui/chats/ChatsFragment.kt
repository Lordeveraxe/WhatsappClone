package com.uptc.whatsapp.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.uptc.whatsapp.R
import com.uptc.whatsapp.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    private val numberOfChats = 15  // Number of dynamic chat items to create

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        addChatsDynamically()
        return root
    }

    private fun addChatsDynamically() {
        val linearLayoutForChats = binding.linearLayoutForChats

        for (i in 1..numberOfChats) {
            val chatView = LayoutInflater.from(context).inflate(R.layout.person, linearLayoutForChats, false).apply {
                findViewById<TextView>(R.id.textView_chat_name).text = "Chat Name $i"
                findViewById<TextView>(R.id.textView_last_message).text = "Last message preview $i"
                findViewById<TextView>(R.id.textView_timestamp).text = "${i}/10/2024"
            }
            linearLayoutForChats.addView(chatView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}