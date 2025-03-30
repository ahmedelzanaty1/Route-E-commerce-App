package com.example.routee_commerceapp.data.repository.Home

import com.example.routee_commerceapp.data.dto.Categories.toCategory
import com.example.routee_commerceapp.data.remote.CategoriesManager
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.domain.repository.Home.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesManager: CategoriesManager

) : CategoriesRepository {
    override suspend fun getCategories(): List<CategoryModel> {
        return categoriesManager.getCategories().data?.map { it.toCategory() } ?: emptyList()

    }
}