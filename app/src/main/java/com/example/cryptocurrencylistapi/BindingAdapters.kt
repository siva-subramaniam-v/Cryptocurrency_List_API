package com.example.cryptocurrencylistapi

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cryptocurrencylistapi.network.CryptoDetails
import com.example.cryptocurrencylistapi.overview.CryptoDetailsAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CryptoDetails>?) {
    val adapter = recyclerView.adapter as CryptoDetailsAdapter
    adapter.submitList(data)
    Log.i("BindingAdapter", "inside bindRecyclerView")
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    Log.i("BindingAdapter", imgUrl!!)
    imgUrl?.let {
        Log.i("BindingAdapter", imgUrl)
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide
            .with(imgView.context)
            .load(imgUri)
            .centerCrop()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(imgView)
    }
}