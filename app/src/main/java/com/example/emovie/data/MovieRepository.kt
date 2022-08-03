package com.example.emovie.data

import com.example.emovie.data.model.TypeCategory
import com.example.emovie.data.model.Data
import com.example.emovie.data.model.MovieDetail
import com.example.emovie.data.network.MovieService
import javax.inject.Inject

class MovieRepository  @Inject constructor( private val api:MovieService){
    suspend fun getAllMovie(typeCategory: TypeCategory): Data?{
        return when(typeCategory){
            TypeCategory.upComing  -> api.getUpComing()
            TypeCategory.topRated  -> api.getTopReted()
            TypeCategory.popular   -> api.getPopular()
        }
    }

    suspend fun getDetail(id:Int): MovieDetail?{
        return if (id!=0){
            api.getMovieDetail(id)
        }else{
            null
        }
    }

}