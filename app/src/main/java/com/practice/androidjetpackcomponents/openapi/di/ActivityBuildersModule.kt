package com.practice.androidjetpackcomponents.openapi.di

import com.practice.androidjetpackcomponents.openapi.di.auth.AuthFragmentBuildersModule
import com.practice.androidjetpackcomponents.openapi.di.auth.AuthModule
import com.practice.androidjetpackcomponents.openapi.di.auth.AuthScope
import com.practice.androidjetpackcomponents.openapi.di.auth.AuthViewModelModule
import com.practice.androidjetpackcomponents.openapi.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

}