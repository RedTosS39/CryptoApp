package com.example.cryptoapp.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.presentation.adapter.CryptoAdapter
import com.example.cryptoapp.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {


    private var coinFragment: CoinFragment? = null
    private lateinit var fragmentContainerView: FragmentContainerView

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun launchFragment(fragment: Fragment) {
        fragmentContainerView = binding.fragmentContainer
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setupRecyclerView() {

        with(binding.recycler) {
            cryptoAdapter = CryptoAdapter()
            adapter = cryptoAdapter

            viewModel.coinInfoList.observe(this@MainActivity) {
                cryptoAdapter.submitList(it)
            }

            cryptoAdapter.onItemClickListener = {
                coinFragment = CoinFragment.newCoinFragmentInstance()
                coinFragment?.arguments?.apply {
                    putString("KEY", it.domainCoinInfo.FullName)
                }
                launchFragment(coinFragment!!)
            }
        }
    }
}