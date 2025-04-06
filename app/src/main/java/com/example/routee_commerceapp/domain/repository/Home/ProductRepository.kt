package com.example.routee_commerceapp.domain.repository.Home

import com.example.routee_commerceapp.domain.model.home.Product.DetailsResponseModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel

interface ProductRepository {
    suspend fun getProducts(): List<ProductModel>
    suspend fun getProductDetails(productId: String): DetailsResponseModel


}