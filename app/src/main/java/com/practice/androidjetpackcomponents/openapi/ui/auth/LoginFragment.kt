package com.practice.androidjetpackcomponents.openapi.ui.auth


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.practice.androidjetpackcomponents.R
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.LoginFields
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseAuthFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"LoginFragment : ${authViewModel.hashCode()}")
        subscribeObservers()
    }

    fun subscribeObservers()
    {
        authViewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.loginFields.let {
                loginFields -> loginFields?.login_email?.let {
                input_email.setText(it)
                input_password.setText(it)
            }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        authViewModel.setLoginFields(
            LoginFields(
            input_email.text.toString(),
            input_password.text.toString()
            )
        )
    }

}
