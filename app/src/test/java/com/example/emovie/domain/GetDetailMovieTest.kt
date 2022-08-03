package com.example.emovie.domain

import com.example.emovie.data.MovieRepository
import com.example.emovie.data.model.Genres
import com.example.emovie.data.model.MovieDetail
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetDetailMovieTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getDetailMovie: GetDetailMovie

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getDetailMovie = GetDetailMovie(movieRepository)
    }

    @Test
    fun `when api is empty then return null`() = runBlocking {

        coEvery { movieRepository.getDetail(0) } returns null
        val response = getDetailMovie(0)
        assert(response == null)
    }

    @Test
    fun `when api is not empty then return MovieDetail`() = runBlocking {
        val id= 10
        val detail = MovieDetail(
            id = 10,
            overview = "hola mundo",
            genres = arrayListOf(),
            original_language = "es",
            original_title = "hola mundo",
            poster_path = "",
            release_date = "",
            title = "",
            vote_average = ""
        )
        coEvery { movieRepository.getDetail(id) } returns detail

        val response = getDetailMovie(id)

        assert(response == detail)
    }



    @Test
    fun `when api returns MovieDetail, check if genre list is not empty`() = runBlocking {
        val id= 10
        val detail = MovieDetail(
            id = 10,
            overview = "hola mundo",
            genres =  listOf(Genres(1, "Aventura")),
            original_language = "es",
            original_title = "hola mundo",
            poster_path = "",
            release_date = "",
            title = "",
            vote_average = ""
        )
        coEvery { movieRepository.getDetail(id) } returns detail

        val response = getDetailMovie(id)!!.genres

        assert(response.isNotEmpty())
    }




}