package com.example.routee_commerceapp.domain.model.Auth.Signup

import com.example.routee_commerceapp.domain.model.Auth.UserModel

data class SignUpModel(
	val message: String? = null,
	val user: UserModel? = null,
	val token: String? = null
)

