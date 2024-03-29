package com.practice.androidjetpackcomponents.openapi.di.auth

import androidx.lifecycle.ViewModel
import com.practice.androidjetpackcomponents.openapi.di.ViewModelKey
import com.practice.androidjetpackcomponents.openapi.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

}