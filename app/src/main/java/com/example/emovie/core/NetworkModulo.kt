package com.example.emovie.core

import com.example.emovie.data.network.MovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModulo {
    @Singleton
    @Provides
    fun provideRetrofit() :Retrofit{
       return  Retrofit.Builder()
           .baseUrl(Config.url)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiCliente(retrofit: Retrofit):MovieApiClient{
        return  retrofit.create(MovieApiClient::class.java)
    }
}
