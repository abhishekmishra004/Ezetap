package com.example.networkmodule.Api

import com.example.networkmodule.Model.ResponseModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiRequests {

    @GET("{path}")
    suspend fun fetchCustomUI(@Path(value = "path", encoded = true) path:String): Response<ResponseModel>

    @GET
    suspend fun fetchImage(@Url url:String): Response<ResponseBody>
}