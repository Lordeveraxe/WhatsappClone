package com.uptc.whatsapp.ui.communities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uptc.whatsapp.databinding.FragmentCommunitiesBinding

class CommunitiesFragment : Fragment() {

    private var _binding: FragmentCommunitiesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val communitiesViewModel =
            ViewModelProvider(this).get(CommunitiesViewModel::class.java)

        _binding = FragmentCommunitiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCommunities
        communitiesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}