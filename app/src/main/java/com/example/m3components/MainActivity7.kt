package com.example.m3components

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.sidesheet.SideSheetBehavior

class MainActivity7 : AppCompatActivity() {
    private lateinit var showSlideSheet: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        showSlideSheet=findViewById(R.id.showSideSheet)
        val bottomSheetBehavior =SideSheetBehavior.from(findViewById(R.id.standard_slide_sheet))

        showSlideSheet.setOnClickListener {
            if (bottomSheetBehavior.state == SideSheetBehavior.STATE_HIDDEN) {
                bottomSheetBehavior.state = SideSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = SideSheetBehavior.STATE_HIDDEN
            }
        }
    }
}