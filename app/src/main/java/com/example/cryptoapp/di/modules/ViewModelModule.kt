package com.example.cryptoapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.di.qualifiers.ViewModelKey
import com.example.cryptoapp.presentation.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindsViewModel(viewModel: MainViewModel) : ViewModel
}