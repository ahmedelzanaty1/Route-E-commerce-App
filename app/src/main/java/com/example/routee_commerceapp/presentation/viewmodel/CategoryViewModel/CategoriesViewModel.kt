package com.example.routee_commerceapp.presentation.viewmodel.CategoryViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class CategoriesViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    private val productsUseCase: ProductUseCase
) : ViewModel() {

    private val _categories = MutableStateFlow<Resource<List<CategoryModel>>>(Resource.Loading())
    val categories: StateFlow<Resource<List<CategoryModel>>> = _categories.asStateFlow()

    var selectedCategory by mutableStateOf<CategoryModel?>(null)
        private set

    private val _productsForSelected = MutableStateFlow<Resource<List<ProductModel>>>(Resource.Loading())
    val productsForSelected: StateFlow<Resource<List<ProductModel>>> = _productsForSelected.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            categoriesUseCase().collect { result ->
                _categories.value = result

                if (result is Resource.Success) {
                    selectedCategory = result.data?.firstOrNull()
                    selectedCategory?.let { fetchProductsForCategory(it) }
                }
            }
        }
    }

    fun selectCategory(category: CategoryModel) {
        selectedCategory = category
        fetchProductsForCategory(category)
    }

    private fun fetchProductsForCategory(category: CategoryModel) {
        viewModelScope.launch {
            productsUseCase().collect { result ->
                if (result is Resource.Success) {
                    val filtered = result.data?.filter {
                        it.category?.name?.equals(category.name, ignoreCase = true) == true
                    }
                    _productsForSelected.value = Resource.Success(filtered ?: emptyList())
                } else {
                    _productsForSelected.value = result
                }
            }
        }
    }
}
