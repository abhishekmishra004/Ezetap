package com.example.ezetapassisgnment.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.networkmodule.Api.ApiRequests
import com.example.networkmodule.Model.ResponseModel
import com.example.networkmodule.interfaces.DataInterface
import javax.inject.Inject

class RetrofitRepoImp @Inject constructor(val apiService: ApiRequests) : DataInterface {

    private val data_response = MutableLiveData<ResponseModel>()
    private val bitmap_response = MutableLiveData<Bitmap>()
    val getData: LiveData<ResponseModel>  get() = data_response
    val getImage: LiveData<Bitmap> get() = bitmap_response

    override fun getCustomUI(): LiveData<ResponseModel> {
        return getData
    }

    override suspend fun fetchCustomUI(path: String) {
        apiService.fetchCustomUI(path).let {response ->
            if (response.isSuccessful){
                data_response.postValue(response.body())
            }else{
                Log.d("tag", "getAllTvShows Error: ${response.code()}")
            }
        }
    }

    override suspend fun fetchImage(url: String) {
        apiService.fetchImage(url).let { response ->
            if(response.isSuccessful){
                bitmap_response.postValue(BitmapFactory.decodeStream(response.body()!!.byteStream()))
            }else{
                Log.d("tag", "fetchImage: failed to fetch image")
            }
        }
    }

    override fun getImage(): LiveData<Bitmap> {
        return getImage
    }
}