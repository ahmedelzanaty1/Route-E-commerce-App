package com.example.routee_commerceapp.data.remote

import com.example.routee_commerceapp.data.dto.Auth.Signin.LoginRequest
import com.example.routee_commerceapp.data.dto.Auth.Signin.SigninResponse
import com.example.routee_commerceapp.data.dto.Auth.Signup.SignupRequest
import com.example.routee_commerceapp.data.dto.Auth.Signup.SignupResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthManager {

    @POST("api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): SigninResponse

    @POST("api/v1/auth/signup")
    suspend fun signUp(
        @Body registerRequest: SignupRequest
    ): SignupResponse
}