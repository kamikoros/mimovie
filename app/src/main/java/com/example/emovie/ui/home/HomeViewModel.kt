package com.example.emovie.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emovie.data.model.Movie
import com.example.emovie.data.model.TypeCategory
import com.example.emovie.domain.GetListMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMovie:GetListMovie)  :ViewModel() {
     val listUpComing = MutableLiveData<List<Movie>>()
     val listTopRated = MutableLiveData<List<Movie>>()
     val listPopular = MutableLiveData<List<Movie>>()

    init {
        setUpComing()
        setTopRated()
        setPopular()
    }

    fun setUpComing(){
        viewModelScope.launch(Dispatchers.IO) {
            val data =  getMovie(TypeCategory.upComing)
            if(data!=null){
                listUpComing.postValue(data.results)
            }
        }

    }
    fun setTopRated() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getMovie(TypeCategory.topRated)
            if (data != null) {
                listTopRated.postValue(data.results)
            }
        }
    }


    fun setPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getMovie(TypeCategory.popular)
            if (data != null) {
                listPopular.postValue(data.results)
            }
        }
    }


    }