package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.presentation.view.MainActivity
import com.example.cryptoapp.presentation.viewmodel.MainViewModel
import com.example.cryptoapp.presentation.viewmodel.MainViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    DataModule::class,
    DomainModule::class
])


interface AppComponent {
    fun inject(activity: MainActivity)

    fun viewModel() : MainViewModel

    fun viewModelFactory() : MainViewModelFactory

/*    @Component.Builder
    interface AppComponentBuilder {


        @BindsInstance
        fun context(context: Context) : AppComponentBuilder

        fun build() : AppComponent
    }*/

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance context: Context
        ) : AppComponent
    }

}