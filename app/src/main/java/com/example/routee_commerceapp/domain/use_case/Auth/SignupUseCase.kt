package com.example.routee_commerceapp.domain.use_case.Auth

import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel
import com.example.routee_commerceapp.domain.repository.Auth.AuthRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(name: String,
                                email: String,
                                password: String,
                                phone: String , passwordConfirm: String): SignUpModel {
        return authRepository.signUp(name, email, password, phone , passwordConfirm)
    }

}