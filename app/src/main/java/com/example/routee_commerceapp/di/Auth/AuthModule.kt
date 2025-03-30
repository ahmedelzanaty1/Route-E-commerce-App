package com.example.routee_commerceapp.di.Auth

import com.example.routee_commerceapp.constants.Utils
import com.example.routee_commerceapp.data.remote.AuthManager
import com.example.routee_commerceapp.data.repository.Auth.AuthRepositoryImpl
import com.example.routee_commerceapp.domain.repository.Auth.AuthRepository
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
    object AuthModule {

        @Provides
        @Singleton
        fun provideAuthManager(retrofit: Retrofit): AuthManager {
            return retrofit.create(AuthManager::class.java)
        }


        @Provides
        @Singleton
        fun provideAuthRepository(authManager: AuthManager): AuthRepository {
            return AuthRepositoryImpl(authManager)
        }
    }

