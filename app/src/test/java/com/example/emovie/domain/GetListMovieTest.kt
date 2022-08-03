package com.example.emovie.domain

import com.example.emovie.data.MovieRepository
import com.example.emovie.data.model.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetListMovieTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getListMovie: GetListMovie

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListMovie = GetListMovie(movieRepository)
    }

    @Test
    fun `when api is empty then return null`() = runBlocking {

        val type = TypeCategory.topRated
        coEvery { movieRepository.getAllMovie(type) } returns null
        val response = getListMovie(type)
        assert(response == null)
    }

    @Test
    fun `when api is not empty then return Data`() = runBlocking {
        val type = TypeCategory.topRated
        val data = Data(
            page = 1,
            total_pages = 10,
            results = arrayListOf(),
            total_results = 12,
        )
        coEvery { movieRepository.getAllMovie(type) } returns data

        val response = getListMovie(type)

        assert(response == data)
    }



    @Test
    fun `when api returns Data, check if Movie list is not empty`() = runBlocking {
        val type = TypeCategory.topRated
        val data = Data(
            page = 1,
            total_pages = 10,
            results = listOf(
                Movie(
                    adult = false,
                    id = 10,
                    overview = "hola mundo",
                    original_language = "es",
                    original_title = "hola mundo",
                    poster_path = "",
                    release_date = "",
                    title = "",
                    backdrop_path = "",
                    popularity = ""
                )
            ),
            total_results = 12,
        )
        coEvery { movieRepository.getAllMovie(type) } returns data

        val response = getListMovie(type)!!.results

        assert(response.isNotEmpty())
    }






}