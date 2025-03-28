package com.example.routee_commerceapp.data.dto.Auth.Signup

import com.google.gson.annotations.SerializedName

data class SignupRequest(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("rePassword")
    val rePassword: String,

    @field:SerializedName("phone")
    val phone: String
)
