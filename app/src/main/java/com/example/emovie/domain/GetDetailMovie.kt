package com.example.emovie.domain

import com.example.emovie.data.model.MovieDetail
import com.example.emovie.data.MovieRepository
import javax.inject.Inject

class GetDetailMovie @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke(id:Int): MovieDetail? = repository.getDetail(id)
}