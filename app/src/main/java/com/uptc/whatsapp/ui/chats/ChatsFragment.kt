package com.uptc.whatsapp.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.uptc.whatsapp.R
import com.uptc.whatsapp.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    private val numberOfChats = 5

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
        var prevViewId = ConstraintSet.PARENT_ID

        for (i in 1..numberOfChats) {
            val chatView = LayoutInflater.from(context).inflate(R.layout.person, null, false).apply {
                id = View.generateViewId()
                findViewById<TextView>(R.id.textView_chat_name).text = "Chat Name $i"
                findViewById<TextView>(R.id.textView_last_message).text = "Last message preview $i"
                findViewById<TextView>(R.id.textView_timestamp).text = "${10 + i}:00 PM"
            }

            binding.constraintLayout.addView(chatView)

            val set = ConstraintSet()
            set.clone(binding.constraintLayout)
            set.connect(chatView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
            set.connect(chatView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
            set.connect(chatView.id, ConstraintSet.TOP, prevViewId, if (i == 1) ConstraintSet.TOP else ConstraintSet.BOTTOM, 8)
            set.applyTo(binding.constraintLayout)

            prevViewId = chatView.id
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}