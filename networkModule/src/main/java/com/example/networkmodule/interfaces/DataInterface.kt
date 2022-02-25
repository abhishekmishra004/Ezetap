package com.example.networkmodule.interfaces

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.example.networkmodule.Model.ResponseModel
import com.example.networkmodule.Repository.RetrofitRepo
import javax.inject.Inject

interface DataInterface  {

    fun getCustomUI() : LiveData<ResponseModel>

    suspend fun fetchCustomUI(path: String)

    suspend fun fetchImage(url: String)

    fun getImage() : LiveData<Bitmap>

}