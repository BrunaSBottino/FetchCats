package com.challenge.fetchcats.network

import com.challenge.fetchcats.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface API {

    @GET("3/gallery/search/?q=cats")
    suspend fun fetchCats(@Header("Authorization") key:String) : Response<DataResponse>

}