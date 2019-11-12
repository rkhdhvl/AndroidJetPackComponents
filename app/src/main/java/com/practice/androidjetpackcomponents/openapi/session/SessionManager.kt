package com.practice.androidjetpackcomponents.openapi.session

import android.app.Application
import com.practice.androidjetpackcomponents.openapi.persistence.AuthTokenDao
import javax.inject.Inject

class SessionManager
@Inject
constructor(val authTokenDao: AuthTokenDao,
            val applicaton:Application)
{

}