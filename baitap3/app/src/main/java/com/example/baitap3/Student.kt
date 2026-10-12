package com.example.baitap3

import java.io.Serializable

data class Student(
    var maSinhVien: String,
    var hoTen: String,
    var lop: String,
    var nganh: String,
    var gpa: Double
) : Serializable