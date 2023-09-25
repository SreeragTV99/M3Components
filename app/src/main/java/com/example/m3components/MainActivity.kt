package com.example.m3components

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var indicator: ScrollingPagerIndicator
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redirectButton = findViewById<View>(R.id.floating_action_button)
        indicator=findViewById(R.id.indicator)

        redirectButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.carouselRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Create a list of data (e.g., image URLs)
        val imageList = ArrayList<Int>()
        imageList.add(R.drawable.carousel1)
        imageList.add(R.drawable.carousel2)
        imageList.add(R.drawable.carousel3)
        imageList.add(R.drawable.carousel4)
        imageList.add(R.drawable.carousel5)
        imageList.add(R.drawable.carousel6)
        // Add more image URLs as needed

        // Create an adapter and set it to the RecyclerView
        val adapter = CarouselAdapter(imageList)
        recyclerView.adapter = adapter


        indicator.attachToRecyclerView(recyclerView)
        indicator.dotColor = ContextCompat.getColor(this, R.color.dot_unselected_color)
        indicator.selectedDotColor = ContextCompat.getColor(this, R.color.dot_selected_color)
        indicator.setDotCount(6)
    }
}