package com.practice.androidjetpackcomponents.openapi.api.auth

import androidx.lifecycle.LiveData
import com.practice.androidjetpackcomponents.openapi.api.auth.network_responses.LoginResponse
import com.practice.androidjetpackcomponents.openapi.util.GenericApiResponse
import com.practice.androidjetpackcomponents.openapi.util.LiveDataCallAdapterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OpenApiAuthService {

    @POST("account/login")
    @FormUrlEncoded
    fun login(
        @Field("username") email:String,
        @Field("password") password:String
    ): LiveData<GenericApiResponse<LoginResponse>>

    @POST("account/register")
    @FormUrlEncoded
    fun register(
        @Field("email") email : String,
        @Field("username") username : String,
        @Field("password") password : String,
        @Field("password2") password2 : String
    )

}