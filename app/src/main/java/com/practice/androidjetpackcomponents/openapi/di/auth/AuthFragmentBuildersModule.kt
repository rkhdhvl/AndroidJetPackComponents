package com.practice.androidjetpackcomponents.openapi.di.auth

import com.practice.androidjetpackcomponents.openapi.ui.auth.ForgotPasswordFragment
import com.practice.androidjetpackcomponents.openapi.ui.auth.LauncherFragment
import com.practice.androidjetpackcomponents.openapi.ui.auth.LoginFragment
import com.practice.androidjetpackcomponents.openapi.ui.auth.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AuthFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun contributeRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector()
    abstract fun contributeForgotPasswordFragment(): ForgotPasswordFragment

}
