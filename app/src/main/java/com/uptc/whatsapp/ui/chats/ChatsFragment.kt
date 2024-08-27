package com.uptc.whatsapp.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uptc.whatsapp.databinding.FragmentChatsBinding
import com.uptc.whatsapp.ui.chats.adapters.ChatsAdapter
import com.uptc.whatsapp.ui.chats.items.ChatItem

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    private val numberOfChats = 15

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        val recyclerViewForChats = binding.recyclerViewForChats
        recyclerViewForChats.layoutManager = LinearLayoutManager(context)
        recyclerViewForChats.adapter = ChatsAdapter(generateChats())
    }

    private fun generateChats(): List<ChatItem> {
        val chats = mutableListOf<ChatItem>()
        for (i in 1..numberOfChats) {
            chats.add(ChatItem("Chat Name $i", "Last message preview $i", "${i}/10/2024"))
        }
        return chats
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}