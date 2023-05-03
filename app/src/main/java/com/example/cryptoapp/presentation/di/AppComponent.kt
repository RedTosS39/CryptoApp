package com.example.cryptoapp.presentation.di

import com.example.cryptoapp.presentation.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

}