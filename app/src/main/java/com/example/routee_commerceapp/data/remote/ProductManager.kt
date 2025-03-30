package com.example.routee_commerceapp.data.remote

import com.example.routee_commerceapp.data.dto.Product.ProductsResponse
import retrofit2.http.GET

interface ProductManager {
    @GET("api/v1/products")
    suspend fun getProducts(): ProductsResponse

}