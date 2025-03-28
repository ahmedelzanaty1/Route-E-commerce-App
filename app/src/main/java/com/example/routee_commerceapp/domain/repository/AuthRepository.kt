package com.example.routee_commerceapp.domain.repository

import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel
import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel


interface AuthRepository {
    suspend fun login(email: String, password: String): LogInModel
    suspend fun signUp(name: String, email: String, password: String, phone: String , passwordConfirm: String): SignUpModel
}
