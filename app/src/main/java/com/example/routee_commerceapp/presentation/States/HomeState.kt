package com.example.routee_commerceapp.presentation.States

import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel

sealed class HomeState {
    object Loading : HomeState()
    data class Success(
        val categories: List<CategoryModel>,
        val products: List<ProductModel>
    ) : HomeState()
    data class Error(val message: String) : HomeState()
}