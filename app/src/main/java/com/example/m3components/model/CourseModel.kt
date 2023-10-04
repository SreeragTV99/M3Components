package com.example.m3components.model

class CourseModel (var course_name: String, var imgid: Int) {

    fun getCourseName(): String {
        return course_name
    }

    fun setCourseName(course_name: String) {
        this.course_name = course_name
    }

    fun getImgId() : Int {
        return imgid
    }

    fun setImgId(imgid: Int) {
        this.imgid = imgid
    }
}