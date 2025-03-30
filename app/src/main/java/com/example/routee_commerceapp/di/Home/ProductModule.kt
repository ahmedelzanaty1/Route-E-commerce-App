package com.example.routee_commerceapp.di.Home

import com.example.routee_commerceapp.constants.Utils
import com.example.routee_commerceapp.data.remote.ProductManager
import com.example.routee_commerceapp.data.repository.Home.ProductRepositoryImpl
import com.example.routee_commerceapp.domain.repository.Home.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    @Singleton
    fun provideProductManager(retrofit: Retrofit): ProductManager {
        return retrofit.create(ProductManager::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(productManager: ProductManager): ProductRepository {
        return ProductRepositoryImpl(productManager)
    }

}