package com.example.imageshowusingretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageshowusingretrofit.R
import com.example.imageshowusingretrofit.modals.ImageModel

class ImageAdapter(private var itemList: List<ImageModel>) :
    RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.recyclerview_imageshow, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data: ImageModel = itemList[position]
        val si: String = data.download_url
        holder.imageView.let {
            Glide.with(holder.imageView.context).load(si)

                .into(it)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
