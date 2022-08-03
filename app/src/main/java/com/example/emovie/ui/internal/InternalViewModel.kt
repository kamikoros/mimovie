package com.example.emovie.ui.internal

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emovie.data.model.MovieDetail
import com.example.emovie.domain.GetDetailMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InternalViewModel @Inject constructor(private val getDetail:GetDetailMovie):ViewModel() {
    var detail = MutableLiveData<MovieDetail>()

    fun init(bundle: Bundle?){
        if(bundle != null){
            getData(id = bundle.getInt("id",0))
        }
    }


    fun getData(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val data = getDetail(id)
            Log.e("d",data.toString())
            if(data!=null){
                detail.postValue(data)
            }
        }
    }




}