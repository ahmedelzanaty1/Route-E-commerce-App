package com.example.routee_commerceapp.data.remote

import com.example.routee_commerceapp.data.dto.Categories.CategoriesResponse
import retrofit2.http.GET

interface CategoriesManager {
    @GET("api/v1/categories")
    suspend fun getCategories(): CategoriesResponse

}