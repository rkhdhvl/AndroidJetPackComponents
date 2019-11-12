package com.practice.androidjetpackcomponents.openapi.ui.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.practice.androidjetpackcomponents.openapi.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseAuthFragment : DaggerFragment() {

    val TAG: String = "AppDebug"

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    lateinit var authViewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel = activity?.run {
            ViewModelProvider(this,viewModelProviderFactory).get(AuthViewModel::class.java)
        }?:throw Exception("Invalid Activity")

    }

}