package com.example.m3components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.palette.graphics.Palette

class MainActivity9 : AppCompatActivity() {
    private lateinit var headTV: TextView
    private lateinit var cpaTV: TextView
    private lateinit var cpaIV: ImageView
    private lateinit var backgroundCL: ConstraintLayout
    private lateinit var changeBtn: Button
    private lateinit var changeBtn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        headTV = findViewById(R.id.idTVHead)
        cpaTV = findViewById(R.id.idTVGFG)
        cpaIV = findViewById(R.id.cpaImageView)
        backgroundCL = findViewById(R.id.backgroundCL)
        changeBtn = findViewById(R.id.changeImageBtn1)
        changeBtn2 = findViewById(R.id.changeImageBtn2)

        val bitmap1: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.star1)
        val bitmap2: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.star2)

        createPaletteAsync(bitmap1)
        cpaIV.setImageBitmap(bitmap1)

        changeBtn.setOnClickListener {
            createDarkPaletteAsync(bitmap2)
            cpaIV.setImageBitmap(bitmap2)
        }

        changeBtn2.setOnClickListener {
            createPaletteAsync(bitmap1)
            cpaIV.setImageBitmap(bitmap1)
        }
    }

    fun createDarkPaletteAsync(bitmap: Bitmap?) {

        Palette.from(bitmap!!).generate { p ->
            val defaultValue = 0x000000

            headTV.setTextColor(p!!.getLightVibrantColor(defaultValue))
            cpaTV.setTextColor(p.getLightVibrantColor(defaultValue))
            backgroundCL.setBackgroundColor(p.getDarkVibrantColor(defaultValue))
            changeBtn.setTextColor(p.getDarkVibrantColor(defaultValue))
            changeBtn.setBackgroundColor(p.getLightVibrantColor(defaultValue))
            changeBtn2.setTextColor(p.getDarkVibrantColor(defaultValue))
            changeBtn2.setBackgroundColor(p.getLightVibrantColor(defaultValue))
        }
    }
    fun createPaletteAsync(bitmap: Bitmap?) {
        Palette.from(bitmap!!).generate { p ->
            val defaultValue = 0x000000

            headTV.setTextColor(p!!.getDarkVibrantColor(defaultValue))
            cpaTV.setTextColor(p.getDarkVibrantColor(defaultValue))
            backgroundCL.setBackgroundColor(p.getLightVibrantColor(defaultValue))
            changeBtn.setTextColor(p.getLightVibrantColor(defaultValue))
            changeBtn.setBackgroundColor(p.getDarkVibrantColor(defaultValue))
            changeBtn2.setTextColor(p.getLightVibrantColor(defaultValue))
            changeBtn2.setBackgroundColor(p.getDarkVibrantColor(defaultValue))
        }
    }
}


