package com.example.emovie.data.network
import com.example.emovie.core.Config
import com.example.emovie.data.model.Data
import com.example.emovie.data.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(val api:MovieApiClient) {
    suspend fun get(): Data? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllUpComing(Config.apiKey)
            response.body()
        }
    }

    suspend fun getTopReted(): Data? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllTopRated(Config.apiKey)
            response.body()
        }
    }

    suspend fun getPopular(): Data? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPopular(Config.apiKey)
            response.body()
        }
    }


    suspend fun getMovieDetail(id:Int): MovieDetail? {
        return withContext(Dispatchers.IO) {
            val response = api.getDetail(
                id =  id,
                api_key = Config.apiKey)
            response.body()
        }
    }
}