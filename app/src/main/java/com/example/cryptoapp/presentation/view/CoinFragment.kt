package com.example.cryptoapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cryptoapp.databinding.FragmentCoinBinding

class CoinFragment : Fragment() {

    private var _binding : FragmentCoinBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentCoinBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCoinLabel.text = arguments?.getString("KEY") ?: "NO DATA"

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newCoinFragmentInstance() : CoinFragment {
            return CoinFragment().apply {
                arguments = Bundle().apply {
                    getString("KEY")
                }
            }
        }
    }
}