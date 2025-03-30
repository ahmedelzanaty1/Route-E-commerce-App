package com.example.routee_commerceapp.data.repository.Auth

import com.example.routee_commerceapp.data.dto.Auth.Signin.LoginRequest
import com.example.routee_commerceapp.data.dto.Auth.Signup.SignupRequest
import com.example.routee_commerceapp.data.dto.Mapper.toLogInModel
import com.example.routee_commerceapp.data.dto.Mapper.toSignUpModel
import com.example.routee_commerceapp.data.remote.AuthManager
import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel
import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel
import com.example.routee_commerceapp.domain.repository.Auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authManager: AuthManager
) : AuthRepository {
    override suspend fun login(email: String, password: String): LogInModel {
        val response = authManager.login(
            loginRequest = LoginRequest(email = email, password = password)
        )
        return response.toLogInModel()
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String,
        phone: String,
        passwordConfirm: String
    ): SignUpModel {
        val response = authManager.signUp(
            registerRequest = SignupRequest(name = name, email = email, password = password, phone = phone, rePassword = password)
        )
        return response.toSignUpModel()
    }
}
