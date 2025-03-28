package com.example.routee_commerceapp.domain.model.Auth.Login

import com.example.routee_commerceapp.domain.model.Auth.UserModel

data class LogInModel(
	val message: String? = null,
	val user: UserModel? = null,
	val token: String? = null
)

