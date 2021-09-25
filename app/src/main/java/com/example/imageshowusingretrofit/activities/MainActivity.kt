package com.example.imageshowusingretrofit.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imageshowusingretrofit.adapters.ImageAdapter
import com.example.imageshowusingretrofit.databinding.ActivityMainBinding
import com.example.imageshowusingretrofit.modals.ImageModel
import com.example.imageshowusingretrofit.services.ImageService
import com.example.imageshowusingretrofit.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        loadImage()
    }

    private fun loadImage() {
        val imageService: ImageService = ServiceBuilder.buildService(ImageService::class.java)

        val requestCall: Call<List<ImageModel>> = imageService.getImageList()
        requestCall.enqueue(object : Callback<List<ImageModel>> {
            override fun onResponse(
                call: Call<List<ImageModel>>,
                response: Response<List<ImageModel>>
            ) {
                if (response.isSuccessful) {
                    val imageList: List<ImageModel> = response.body()!!

                    bind.imageRecyclerView.layoutManager = GridLayoutManager(

                        applicationContext,
                        2
                    )
                    imageAdapter = ImageAdapter(imageList)
                    bind.imageRecyclerView.adapter = imageAdapter
                }
            }

            override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {

            }

        })

    }
}