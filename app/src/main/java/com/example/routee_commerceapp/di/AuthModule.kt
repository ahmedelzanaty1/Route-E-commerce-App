package com.example.routee_commerceapp.di

import com.example.routee_commerceapp.constants.Utils
import com.example.routee_commerceapp.data.remote.AuthManager
import com.example.routee_commerceapp.data.repository.Auth.AuthRepositoryImpl
import com.example.routee_commerceapp.domain.repository.AuthRepository
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

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
