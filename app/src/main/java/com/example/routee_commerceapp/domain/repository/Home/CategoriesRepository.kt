package com.example.routee_commerceapp.domain.repository.Home

import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoryModel>

}