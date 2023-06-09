package com.example.cryptoapp.di.components

import com.example.cryptoapp.di.modules.ViewModelModule
import com.example.cryptoapp.di.modules.WorkerModule
import com.example.cryptoapp.di.qualifiers.IdQualifier
import com.example.cryptoapp.presentation.view.CoinFragment
import com.example.cryptoapp.presentation.view.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

//@Subcomponent()
//interface ActivityComponent {
//
//    @Subcomponent.Factory
//    interface Factory {
//
//        fun create(
//            @BindsInstance @IdQualifier id: String,
//        ): ActivityComponent
//    }
//}