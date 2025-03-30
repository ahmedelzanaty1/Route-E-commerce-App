package com.example.routee_commerceapp.presentation.viewmodel.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.domain.use_case.Home.CategoriesUseCase
import com.example.routee_commerceapp.domain.use_case.Home.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val productsUseCase: ProductUseCase
) : ViewModel() {

    private val _categoriesState = MutableStateFlow<Resource<List<CategoryModel>>>(Resource.Loading())
    val categoriesState: StateFlow<Resource<List<CategoryModel>>> = _categoriesState.asStateFlow()

    private val _productsState = MutableStateFlow<Resource<List<ProductModel>>>(Resource.Loading())
    val productsState: StateFlow<Resource<List<ProductModel>>> = _productsState.asStateFlow()

    init {
        getCategories()
        getProducts()
    }

    private fun getCategories() {
        viewModelScope.launch {
            categoriesUseCase().collect { result ->
                _categoriesState.value = result
            }
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            productsUseCase().collect { result ->
                _productsState.value = result
            }
        }
    }
}