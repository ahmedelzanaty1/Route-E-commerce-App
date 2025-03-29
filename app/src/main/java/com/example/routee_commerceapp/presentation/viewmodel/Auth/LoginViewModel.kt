package com.example.routee_commerceapp.presentation.viewmodel.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.data.DataStore.DataStoreManager
import com.example.routee_commerceapp.domain.model.Auth.Login.LogInModel
import com.example.routee_commerceapp.domain.use_case.Auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _loginState = MutableStateFlow<Resource<LogInModel>>(Resource.Loading())
    val loginState: StateFlow<Resource<LogInModel>> = _loginState
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Resource.Loading()
            try {
                val result = loginUseCase(email, password)
                dataStoreManager.saveToken(result.token ?: "")
                _loginState.value = Resource.Success(result)
            } catch (e: Exception) {
                _loginState.value = Resource.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }
}