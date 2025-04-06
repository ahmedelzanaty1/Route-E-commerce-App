package com.example.routee_commerceapp.domain.use_case.Home

import android.util.Log
import com.example.routee_commerceapp.constants.Resource
import com.example.routee_commerceapp.domain.model.home.Product.DetailsResponseModel
import com.example.routee_commerceapp.domain.model.home.Product.ProductModel
import com.example.routee_commerceapp.domain.repository.Home.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val productRepository: ProductRepository

) {
    suspend operator fun invoke(productId: String) : Flow<Resource<DetailsResponseModel>> = flow {
        try {
            emit(Resource.Loading())
            Log.d("DetailsUseCase", "Fetching details for productId: $productId") // Add log here to check the ID being passed
            val product = productRepository.getProductDetails(productId)
            Log.d("DetailsUseCase", "Fetched product: $product")
            emit(Resource.Success(product))
        // Add log here to check the fetched product

        }catch (e : Exception){

            emit(Resource.Error(e.message ?: "An error occurred"))

        }
    }

}