package com.example.routee_commerceapp.presentation.viewmodel.Home

import android.util.Log
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

    private val _mobileProductsState = MutableStateFlow<Resource<List<ProductModel>>>(Resource.Loading())
    val mobileProductsState: StateFlow<Resource<List<ProductModel>>> = _mobileProductsState.asStateFlow()

    private val _womenProductsState = MutableStateFlow<Resource<List<ProductModel>>>(Resource.Loading())
    val womenProductsState: StateFlow<Resource<List<ProductModel>>> = _womenProductsState.asStateFlow()

    init {
        getCategories()
        getProducts()
        getMobileProducts()
        getWomenProducts()
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
    private fun getMobileProducts() {
        viewModelScope.launch {
            productsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {

                        result.data?.forEach { product ->
                            Log.e("ProductCategory", "Category: ${product.category?.name}")
                        }

                        val mobileProducts = result.data?.filter {
                            it.category?.name?.contains("Electronics", ignoreCase = true) == true
                        }

                        _mobileProductsState.value = Resource.Success(mobileProducts ?: emptyList())
                    }
                    is Resource.Error -> _mobileProductsState.value = Resource.Error(result.message ?: "An error occurred")
                    is Resource.Loading -> _mobileProductsState.value = Resource.Loading()
                }
            }
        }
    }
    private fun getWomenProducts() {
        viewModelScope.launch {
            productsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {

                        result.data?.forEach { product ->
                            Log.e("ProductCategory", "Category: ${product.category?.name}")
                        }

                        val WomenProducts = result.data?.filter {
                            it.category?.name?.contains("Women's Fashion", ignoreCase = true) == true
                        }

                        _womenProductsState.value = Resource.Success(WomenProducts ?: emptyList())
                    }
                    is Resource.Error -> _mobileProductsState.value = Resource.Error(result.message ?: "An error occurred")
                    is Resource.Loading -> _mobileProductsState.value = Resource.Loading()
                }
            }
        }
    }

}