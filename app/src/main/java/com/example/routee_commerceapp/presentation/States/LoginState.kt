package com.example.routee_commerceapp.presentation.States

import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val data: LogInModel) : LoginState()
    data class Error(val message: String) : LoginState()
    object Idle : LoginState()
}