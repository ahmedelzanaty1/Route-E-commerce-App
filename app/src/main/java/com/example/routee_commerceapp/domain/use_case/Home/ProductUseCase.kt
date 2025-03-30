package com.example.routee_commerceapp.domain.use_case.Home

import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.domain.repository.Home.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val productRepository: ProductRepository

) {
    suspend operator fun invoke(): Flow<Resource<List<ProductModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = productRepository.getProducts()
            emit(Resource.Success(products))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An error occurred"))
        }
    }
}