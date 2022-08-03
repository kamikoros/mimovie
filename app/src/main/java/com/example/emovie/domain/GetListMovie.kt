package com.example.emovie.domain

import com.example.emovie.data.model.TypeCategory
import com.example.emovie.data.model.Data
import com.example.emovie.data.MovieRepository
import javax.inject.Inject

class GetListMovie @Inject constructor(private val repository:MovieRepository){

    suspend operator fun invoke(type:TypeCategory): Data? = repository.getAllMovie(type)
}