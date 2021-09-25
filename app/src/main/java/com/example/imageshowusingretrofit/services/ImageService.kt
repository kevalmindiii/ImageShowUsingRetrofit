package com.example.imageshowusingretrofit.services

import retrofit2.Call
import com.example.imageshowusingretrofit.modals.ImageModel
import retrofit2.http.GET

//interface is used to define http methods
interface ImageService {
    @GET("list")
    fun getImageList(): Call<List<ImageModel>>
}