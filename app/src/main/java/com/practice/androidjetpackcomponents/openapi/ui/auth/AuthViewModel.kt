package com.practice.androidjetpackcomponents.openapi.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingwithmitch.openapi.ui.BaseViewModel
import com.codingwithmitch.openapi.util.AbsentLiveData
import com.practice.androidjetpackcomponents.openapi.model.AuthToken
import com.practice.androidjetpackcomponents.openapi.repository.auth.AuthRepository
import com.practice.androidjetpackcomponents.openapi.ui.DataState
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.AuthStateEvent
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.AuthStateEvent.*
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.AuthViewState
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.LoginFields
import com.practice.androidjetpackcomponents.openapi.ui.auth.state.RegistrationFields
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(authRepository: AuthRepository): BaseViewModel<AuthStateEvent,AuthViewState>() {
    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        when(stateEvent){
            is LoginAttemptEvent->{
              return AbsentLiveData.create()
            }
            is RegisterAttemptEvent->{
              return AbsentLiveData.create()
            }
            is CheckPreviousAuthEvent->{
              return AbsentLiveData.create()
            }
        }
    }

    override fun initNewViewState(): AuthViewState {
       return AuthViewState()
    }


    fun setRegistrationFields(registrationFields: RegistrationFields){
        val update = getCurrentViewStateOrNew()
        if(update.registrationFields == registrationFields){
            return
        }
        update.registrationFields = registrationFields
        setViewState(update)
    }

    fun setLoginFields(loginFields: LoginFields){
        val update = getCurrentViewStateOrNew()
        if(update.loginFields == loginFields){
            return
        }
        update.loginFields = loginFields
        setViewState(update)
    }

    fun setAuthToken(authToken: AuthToken){
        val update = getCurrentViewStateOrNew()
        if(update.authToken == authToken){
            return
        }
        update.authToken = authToken
        setViewState(update)
    }

}