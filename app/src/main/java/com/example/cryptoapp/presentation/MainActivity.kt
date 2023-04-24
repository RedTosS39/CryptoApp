package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.presentation.adapter.CryptoAdapter

class MainActivity : AppCompatActivity() {

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
        setupViewModel()

    }

    private fun setupViewModel() {
        viewModel.liveData.observe(this) {
            cryptoAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        with(binding.recycler) {
            cryptoAdapter = CryptoAdapter()
            adapter = cryptoAdapter
        }
    }
}