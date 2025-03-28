package com.example.routee_commerceapp.data.dto.Mapper

import com.example.routee_commerceapp.data.dto.Auth.Signin.SigninResponse
import com.example.routee_commerceapp.data.dto.Auth.Signup.SignupResponse
import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel
import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel
import com.example.routee_commerceapp.domain.model.Auth.UserModel

// SigninResponse -> LogInModel
fun SigninResponse.toLogInModel(): LogInModel {
    return LogInModel(
        message = this.message,
        user = this.user?.toUserModel(),
        token = this.token
    )
}

// SignupResponse -> SignUpModel
fun SignupResponse.toSignUpModel(): SignUpModel {
    return SignUpModel(
        message = this.message,
        user = this.user?.toUserModel(),
        token = this.token
    )
}

// User DTO -> UserModel
fun com.example.routee_commerceapp.data.dto.Auth.Signin.UserSignin.toUserModel(): UserModel {
    return UserModel(
        role = this.role,
        name = this.name,
        email = this.email
    )
}

// User DTO -> UserModel (Signup)
fun com.example.routee_commerceapp.data.dto.Auth.Signup.UserSignup.toUserModel(): UserModel {
    return UserModel(
        role = this.role,
        name = this.name,
        email = this.email
    )
}