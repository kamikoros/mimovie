package com.example.emovie.data

import com.example.emovie.data.model.TypeCategory
import com.example.emovie.data.network.MovieService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class MovieRepositoryTest{

    @RelaxedMockK
    lateinit var api: MovieService

    private lateinit var movieRepository: MovieRepository


    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        movieRepository = MovieRepository(api)
    }

    @Test
    fun `Check if the option is selected entered correct method`() = runBlocking {
        //Given
        val type = TypeCategory.upComing
        coEvery { api.getUpComing() } returns null
        //When
        movieRepository.getAllMovie(type)
        //Then
        coVerify(exactly = 1) { api.getUpComing() }
        coVerify(exactly = 0) { api.getTopReted() }
        coVerify(exactly = 0) { api.getPopular()  }
    }




}