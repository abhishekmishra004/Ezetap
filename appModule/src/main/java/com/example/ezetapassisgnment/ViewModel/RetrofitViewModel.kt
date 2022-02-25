package com.example.ezetapassisgnment.ViewModel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ezetapassisgnment.repository.RetrofitRepoImp
import com.example.networkmodule.Model.ResponseModel
import com.example.networkmodule.Repository.RetrofitRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RetrofitViewModel @Inject constructor(val repo: RetrofitRepoImp)  : ViewModel() {

    val getData: LiveData<ResponseModel> get() = repo.getCustomUI()
    val getImage: LiveData<Bitmap> get() = repo.getImage()


    fun fetchCustomUI(path:String) {
        viewModelScope.launch {
            repo.fetchCustomUI(path)
        }
    }

    fun fetchImage(logo: String) {
        viewModelScope.launch {
            repo.fetchImage(logo)
        }
    }


}













