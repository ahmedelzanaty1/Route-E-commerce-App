package com.example.routee_commerceapp.data.dto.Auth.Signup

import com.google.gson.annotations.SerializedName

data class SignupResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: UserSignup? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class UserSignup(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
