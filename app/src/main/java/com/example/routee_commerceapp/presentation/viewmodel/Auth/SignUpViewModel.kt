package com.example.routee_commerceapp.presentation.viewmodel.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel
import com.example.routee_commerceapp.domain.use_case.Auth.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignUpViewModel  @Inject constructor(
    private val signUpUseCase: SignupUseCase
): ViewModel() {
    private val _signupstate = MutableStateFlow<Resource<SignUpModel>>(Resource.Loading())
    val registerState: StateFlow<Resource<SignUpModel>> = _signupstate
    fun register(name: String, email: String, password: String, phone: String) {
        viewModelScope.launch {
            _signupstate.value = Resource.Loading()
            try {
                val result = signUpUseCase(name, email, password, phone)
                _signupstate.value = Resource.Success(result)
            } catch (e: Exception) {
                _signupstate.value = Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}