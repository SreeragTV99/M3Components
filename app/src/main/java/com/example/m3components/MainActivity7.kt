package com.example.m3components

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.GridView
import android.widget.ImageButton
import android.widget.TextView
import com.example.m3components.adapter.CourseAdapter
import com.example.m3components.model.CourseModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.sidesheet.SideSheetBehavior

class MainActivity7 : AppCompatActivity() {
    private lateinit var showSlideSheet: Button
    private lateinit var coursesGV: GridView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        showSlideSheet = findViewById(R.id.showSideSheet)
        val bottomSheetBehavior = SideSheetBehavior.from(findViewById(R.id.standard_slide_sheet))
        val backButton: ImageButton = findViewById(R.id.backbutton)
        val textView: TextView = findViewById(R.id.textView)
        val fade_in: MaterialButton = findViewById(R.id.fade_in)
        val fade_out: MaterialButton = findViewById(R.id.fade_out)
        val zoom_in: MaterialButton = findViewById(R.id.zoom_in)
        val zoom_out: MaterialButton = findViewById(R.id.zoom_out)
        val slide_down: MaterialButton = findViewById(R.id.slide_down)
        val slide_up: MaterialButton = findViewById(R.id.slide_up)
        val bounce: MaterialButton = findViewById(R.id.bounce)
        val rotate: MaterialButton = findViewById(R.id.rotate)

        showSlideSheet.setOnClickListener {
            if (bottomSheetBehavior.state == SideSheetBehavior.STATE_HIDDEN) {
                bottomSheetBehavior.state = SideSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = SideSheetBehavior.STATE_HIDDEN
            }
        }
        backButton.setOnClickListener {
            bottomSheetBehavior.state = SideSheetBehavior.STATE_HIDDEN
        }

        fade_in.setOnClickListener {
            textView.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in1)
            textView.startAnimation(animationFadeIn)
        }
        fade_out.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            textView.startAnimation(animationFadeOut)
            Handler().postDelayed({
                textView.visibility = View.GONE
            }, 1000)
        }
        zoom_in.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            textView.startAnimation(animationZoomIn)
        }
        zoom_out.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            textView.startAnimation(animationZoomOut)
        }
        slide_down.setOnClickListener {
            val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            textView.startAnimation(animationSlideDown)
        }
        slide_up.setOnClickListener {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            textView.startAnimation(animationSlideUp)
        }
        bounce.setOnClickListener {
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            textView.startAnimation(animationBounce)
        }
        rotate.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            textView.startAnimation(animationRotate)
        }

        coursesGV = findViewById(R.id.gridView)
        val courseModelArrayList: ArrayList<CourseModel> = ArrayList<CourseModel>()

        courseModelArrayList.add(CourseModel("DSA", R.drawable.components))
        courseModelArrayList.add(CourseModel("JAVA", R.drawable.components))
        courseModelArrayList.add(CourseModel("C++", R.drawable.components))
        courseModelArrayList.add(CourseModel("Python", R.drawable.components))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.components))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.components))

        val adapter = CourseAdapter(this, courseModelArrayList)
        coursesGV.adapter = adapter

    }
}