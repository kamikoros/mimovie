package com.example.emovie.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.emovie.databinding.ActivityHomeBinding
import com.example.emovie.ui.internal.InternalActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val viewModel: HomeViewModel by viewModels()
    lateinit var adapterUpComing: AdapteListMovies
    lateinit var adapterTopRated: AdapteListMovies
    lateinit var adapterPopular: AdapteListMovies


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterUpComing = AdapteListMovies(arrayListOf()){
            startActivity(Intent(this,InternalActivity::class.java)
                .putExtra("id",it.id)
            )
        }
        adapterTopRated = AdapteListMovies(arrayListOf()){
            startActivity(Intent(this,InternalActivity::class.java)
                .putExtra("id",it.id)
            )
        }
        adapterPopular = AdapteListMovies(arrayListOf()){
            startActivity(Intent(this,InternalActivity::class.java)
                .putExtra("id",it.id)
            )
        }
        binding.recyclerView.adapter = adapterPopular
        binding.recyclerView2.adapter = adapterTopRated
        binding.recyclerView3.adapter = adapterUpComing
        viewModel.listUpComing.observe(this){
            adapterUpComing.setData(it)
        }
        viewModel.listTopRated.observe(this){
            adapterTopRated.setData(it)
        }
        viewModel.listPopular.observe(this){
            adapterPopular.setData(it)
        }
    }
}