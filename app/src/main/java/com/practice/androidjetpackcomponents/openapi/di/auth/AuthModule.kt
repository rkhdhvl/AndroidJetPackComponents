package com.practice.androidjetpackcomponents.openapi.di.auth

import com.practice.androidjetpackcomponents.openapi.api.auth.OpenApiAuthService
import com.practice.androidjetpackcomponents.openapi.persistence.AccountPropertiesDao
import com.practice.androidjetpackcomponents.openapi.persistence.AuthTokenDao
import com.practice.androidjetpackcomponents.openapi.repository.auth.AuthRepository
import com.practice.androidjetpackcomponents.openapi.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class AuthModule{


    // TEMPORARY
    @AuthScope
    @Provides
    fun provideFakeApiService(): OpenApiAuthService{
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz")
            .build()
            .create(OpenApiAuthService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenApiAuthService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }

}