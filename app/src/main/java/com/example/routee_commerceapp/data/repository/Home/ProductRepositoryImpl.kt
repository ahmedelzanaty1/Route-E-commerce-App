package com.example.routee_commerceapp.data.repository.Home

import com.example.routee_commerceapp.data.dto.Product.toProduct
import com.example.routee_commerceapp.data.remote.ProductManager
import com.example.routee_commerceapp.domain.model.home.Product.DataModel
import com.example.routee_commerceapp.domain.model.home.Product.DetailsResponseModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.domain.repository.Home.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productManager: ProductManager
) : ProductRepository {
    override suspend fun getProducts(): List<ProductModel> {
        val response = productManager.getProducts()
        return response.data?.map { it.toProduct() } ?: emptyList()


    }

    override suspend fun getProductDetails(productId: String): DetailsResponseModel {
        val response = productManager.getProductDetails(productId)
        return response.toProduct()
    }
}