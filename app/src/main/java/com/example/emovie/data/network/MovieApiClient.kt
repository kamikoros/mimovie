package com.example.emovie.data.network

import com.example.emovie.data.model.Data
import com.example.emovie.data.model.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiClient {
    @GET("movie/upcoming")
    suspend fun getAllUpComing(@Query("api_key") key: String): Response<Data>

    @GET("movie/top_rated")
    suspend fun getAllTopRated(@Query("api_key") key: String): Response<Data>

    @GET("movie/popular")
    suspend fun getAllPopular(@Query("api_key") key: String): Response<Data>

    @GET("movie/{movie_id}")
    suspend fun getDetail(@Path("movie_id") id: Int, @Query("api_key") api_key:String): Response<MovieDetail>

}