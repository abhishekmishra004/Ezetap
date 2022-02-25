package com.example.networkmodule.Repository

import com.example.networkmodule.Api.ApiRequests
import javax.inject.Inject


class RetrofitRepo @Inject constructor(val apiService: ApiRequests) {

    suspend fun fetchCustomUI(path:String) = apiService.fetchCustomUI(path)

    suspend fun fetchImage(url:String) = apiService.fetchImage(url)
}