package com.example.routee_commerceapp.presentation.viewmodel.Auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.data.DataStore.DataStoreManager
import com.example.routee_commerceapp.domain.model.Auth.Signup.SignUpModel
import com.example.routee_commerceapp.domain.use_case.Auth.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignUpViewModel  @Inject constructor(
    private val signUpUseCase: SignupUseCase,
    private val dataStoreManager: DataStoreManager
): ViewModel() {
    private val _signupstate = MutableStateFlow<Resource<SignUpModel>>(Resource.Loading())
    val registerState: StateFlow<Resource<SignUpModel>> = _signupstate
    fun register(name: String, email: String, password: String, phone: String , passwordConfirm: String) {
        viewModelScope.launch {
            _signupstate.value = Resource.Loading()
            Log.d("SignUpViewModel", "SignUp Request - Name: $name, Email: $email, Password: $password, PasswordConfirm: $passwordConfirm, Phone: $phone")
            try {
                val result = signUpUseCase(name, email, password, phone , passwordConfirm)
                dataStoreManager.saveToken(result.token ?: "")
                _signupstate.value = Resource.Success(result)
                Log.d("SignUpViewModel", "SignUp Response: $result")
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "SignUp Error: ${e.message}")
                _signupstate.value = Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}