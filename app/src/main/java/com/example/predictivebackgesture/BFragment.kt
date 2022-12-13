package com.example.predictivebackgesture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.predictivebackgesture.databinding.FragmentBBinding

class BFragment : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding: FragmentBBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBBinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.doneButton.setOnClickListener { requireActivity().finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}