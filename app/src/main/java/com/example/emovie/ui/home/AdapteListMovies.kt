package com.example.emovie.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.emovie.core.App
import com.example.emovie.data.model.Movie
import com.example.emovie.databinding.ItemListMovieBinding

class AdapteListMovies  internal constructor(var list: List<Movie>, var result: (movie:Movie) -> Unit ) :
    RecyclerView.Adapter<AdapteListMovies.ViewHolder>() {


    inner class ViewHolder(val binding: ItemListMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.cove.let {
            Glide.with(App.contextApp())
                .load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                .into(it)
        }
        holder.binding.item.setOnClickListener {
            result(item)
        }
    }

    fun setData(list: List<Movie>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}