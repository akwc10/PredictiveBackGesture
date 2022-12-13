package com.example.predictivebackgesture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.predictivebackgesture.databinding.FragmentABinding

class AFragment : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding: FragmentABinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentABinding.inflate(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateToFragmentBButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, BFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}