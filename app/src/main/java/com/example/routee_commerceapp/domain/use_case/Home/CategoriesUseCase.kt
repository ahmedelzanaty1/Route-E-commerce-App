package com.example.routee_commerceapp.domain.use_case.Home

import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.example.routee_commerceapp.domain.repository.Home.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository

) {
    suspend operator fun invoke(): Flow<Resource<List<CategoryModel>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = categoriesRepository.getCategories()
            emit(Resource.Success(categories))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An error occurred"))

        }
    }
    }