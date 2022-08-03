package com.example.emovie.ui.internal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.emovie.core.App
import com.example.emovie.data.model.MovieDetail
import com.example.emovie.databinding.ActivityInternalBinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal

@AndroidEntryPoint
class InternalActivity : AppCompatActivity() {
    lateinit var binding:ActivityInternalBinding
    val viewModel: InternalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.init(intent.extras)
        viewModel.detail.observe(this){
            visualizeData(it)
        }
        binding.goBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    fun visualizeData(detail:MovieDetail){
        binding.backdrop.let {
            val img = "http://image.tmdb.org/t/p/w500${detail.backdrop_path}"
            Log.e("ing",img)
            Glide.with(App.contextApp())
                .load(img)
                .into(it)
        }
        binding.poster.let {
            val img = "http://image.tmdb.org/t/p/w500${detail.poster_path}"
            Log.e("ing",img)
            Glide.with(App.contextApp())
                .load(img)
                .into(it)
        }
         binding.originalLanguage.text = "Lenguaje ${detail.original_language}"
         binding.title.text = detail.title
         binding.voteAverage.text = "${BigDecimal(detail.vote_average).setScale(1, BigDecimal.ROUND_HALF_UP).toString()} (${detail.vote_count} Reviews) "
         binding.releaseDate.text = "Released ${detail.release_date}"
         binding.overview.text =  detail.overview
        //binding.genres.text = viewModel.txtGenres(detail.genres)
    }

}