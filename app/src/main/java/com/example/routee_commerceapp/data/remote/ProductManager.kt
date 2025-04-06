package com.example.routee_commerceapp.data.remote

import com.example.routee_commerceapp.data.dto.Product.DetailsResponse
import com.example.routee_commerceapp.data.dto.Product.ProductDto
import com.example.routee_commerceapp.data.dto.Product.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductManager {
    @GET("api/v1/products")
    suspend fun getProducts(): ProductsResponse

    @GET("api/v1/products/{id}")
    suspend fun getProductDetails(@Path("id") id: String): DetailsResponse
}