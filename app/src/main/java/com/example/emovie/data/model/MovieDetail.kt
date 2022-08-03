package com.example.emovie.data.model

import com.google.gson.annotations.SerializedName

data  class MovieDetail(
    @SerializedName("id")
    val id: Int,

    @SerializedName("genres")
    val genres: List<Genres>,

    @SerializedName("original_title")
    val original_title: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("original_language")
    val original_language:String,

    @SerializedName("title")
    val title: String,

    @SerializedName("vote_average")
    val vote_average: String,


    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("backdrop_path")
    val backdrop_path: String,
@SerializedName("vote_count")
    var vote_count:String
    )