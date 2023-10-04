package com.example.m3components.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.m3components.R
import com.example.m3components.model.CourseModel
import com.google.android.material.textview.MaterialTextView

class CourseAdapter(context: Context, courseModelArrayList: List<CourseModel>) :
    ArrayAdapter<CourseModel?>(context, 0, courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
        }

        val courseModel: CourseModel? = getItem(position)
        val courseTV = listitemView!!.findViewById<MaterialTextView>(R.id.idTVCourse)
        val courseIV = listitemView.findViewById<ImageView>(R.id.idIVcourse)

        courseTV.setText(courseModel?.getCourseName())
        if (courseModel != null) {
            courseIV.setImageResource(courseModel.getImgId())
        }
        return listitemView
    }
}