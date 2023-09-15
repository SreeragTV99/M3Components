package com.example.m3components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CarouselAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_item, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val imageResourceId = imageList[position]

        // Load the image from the resource ID using Glide or another image loading library
        Glide.with(holder.itemView)
            .load(imageResourceId)
            .into(holder.imageView)

        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
        animation.repeatCount = Animation.INFINITE
        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}