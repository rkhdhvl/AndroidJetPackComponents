package com.practice.androidjetpackcomponents.openapi.repository.auth

import com.practice.androidjetpackcomponents.openapi.api.auth.OpenApiAuthService
import com.practice.androidjetpackcomponents.openapi.persistence.AccountPropertiesDao
import com.practice.androidjetpackcomponents.openapi.persistence.AuthTokenDao
import com.practice.androidjetpackcomponents.openapi.session.SessionManager

class AuthRepository constructor(val authTokenDao: AuthTokenDao,
                                 accountPropertiesDao: AccountPropertiesDao,
                                 openApiAuthService: OpenApiAuthService,
                                 sessionManager: SessionManager
) {
}