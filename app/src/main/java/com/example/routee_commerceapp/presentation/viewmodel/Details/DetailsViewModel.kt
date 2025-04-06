package com.example.routee_commerceapp.presentation.viewmodel.Details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Product.DetailsResponseModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.domain.use_case.Home.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase
) : ViewModel() {

    private val _detailsState = MutableStateFlow<Resource<DetailsResponseModel>>(Resource.Loading())
    val detailsState: MutableStateFlow<Resource<DetailsResponseModel>> = _detailsState

    fun getDetails(productId: String) {
        Log.d("DetailsViewModel", "Fetching details for productId: $productId") // Add log here to check the ID being passed
        viewModelScope.launch {
            detailsUseCase(productId).collect { result ->
                Log.d("DetailsViewModel", "Result from UseCase: $result") // Log the result from the use case

                _detailsState.value =  result
            }
        }
    }
}
