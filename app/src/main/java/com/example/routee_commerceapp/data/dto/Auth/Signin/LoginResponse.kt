package com.example.routee_commerceapp.data.dto.Auth.Signin

import com.example.routee_commerceapp.domain.model.Auth.UserModel
import com.google.gson.annotations.SerializedName

data class SigninResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: UserSignin? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class UserSignin(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
