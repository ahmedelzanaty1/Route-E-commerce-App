package com.example.routee_commerceapp.di.Home

import com.example.routee_commerceapp.constants.Utils
import com.example.routee_commerceapp.data.remote.CategoriesManager
import com.example.routee_commerceapp.data.repository.Home.CategoriesRepositoryImpl
import com.example.routee_commerceapp.domain.repository.Home.CategoriesRepository
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
object CategoriesModule {

    @Provides
    @Singleton
    fun provideCategoriesManager(retrofit: Retrofit): CategoriesManager {
        return retrofit.create(CategoriesManager::class.java)
    }


    @Provides
    @Singleton
    fun provideCategoriesRepository(categoriesManager: CategoriesManager): CategoriesRepository {
        return CategoriesRepositoryImpl(categoriesManager)
    }
}

