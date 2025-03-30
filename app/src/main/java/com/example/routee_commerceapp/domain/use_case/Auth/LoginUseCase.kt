package com.example.routee_commerceapp.domain.use_case.Auth

import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel
import com.example.routee_commerceapp.domain.repository.Auth.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): LogInModel {
        return authRepository.login(email, password)
    }

}