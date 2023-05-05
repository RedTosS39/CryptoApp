package com.example.cryptoapp.presentation.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.FragmentCoinBinding
import com.example.cryptoapp.presentation.app.CryptoApp
import com.example.cryptoapp.presentation.viewmodel.MainViewModel
import com.example.cryptoapp.presentation.viewmodel.MainViewModelFactory
import javax.inject.Inject

class CoinFragment : Fragment() {

    private var _binding: FragmentCoinBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentCoinBinding == null")

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    lateinit var viewModel: MainViewModel

    private val component by lazy {
        (requireActivity().application as CryptoApp).component.activityComponentFactory().create("")
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

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
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.coinInfoList.observe(viewLifecycleOwner) {
            Log.d("AAAA", "onViewCreated: ${it[0].domainCoinInfo.FullName}")
        }

       binding.tvCoinLabel.text = getStringFromArgs()
    }

    private fun getStringFromArgs(): String {
        return requireArguments().getString(EXTRA_STRING) ?: NO_DATA
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        const val NO_DATA = "NO DATA iN ARGUMENTS"
        const val EXTRA_STRING = "EXTRA_STRING"
        fun newCoinFragmentInstance(): CoinFragment {
            return CoinFragment().apply {
                arguments = Bundle().apply {
                    getString("KEY")
                }
            }
        }
    }
}