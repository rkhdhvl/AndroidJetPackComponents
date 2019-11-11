package com.practice.androidjetpackcomponents.openapi.session

import android.app.Application
import com.practice.androidjetpackcomponents.openapi.persistence.AuthTokenDao

class SessionManager constructor(val authTokenDao: AuthTokenDao,
                                 val applicaton:Application)
{

}