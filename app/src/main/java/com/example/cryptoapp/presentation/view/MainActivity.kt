package com.example.cryptoapp.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cryptoapp.presentation.app.CryptoApp
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.presentation.adapter.CryptoAdapter
import com.example.cryptoapp.presentation.view.CoinFragment.Companion.EXTRA_STRING
import com.example.cryptoapp.presentation.viewmodel.MainViewModel
import com.example.cryptoapp.presentation.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val component by lazy {
        (application as CryptoApp).component
    }

    private var coinFragment: CoinFragment? = null
    private lateinit var fragmentContainerView: FragmentContainerView

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this@MainActivity)
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

            setupViewModel()

            cryptoAdapter.onItemClickListener = {
                coinFragment = CoinFragment.newCoinFragmentInstance()
                coinFragment?.arguments?.apply {
                    putString(EXTRA_STRING, it.domainCoinInfo.FullName)
                }
                launchFragment(coinFragment!!)
            }
        }

        binding.recycler.itemAnimator = null
    }

    private fun setupViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.sharedFlow.collect() {
                    Log.d("setupViewModel", "setupViewModel: ${it.get(1).domainCoinInfo.FullName}")
                    cryptoAdapter.submitList(it)
                }
            }
        }
    }
}