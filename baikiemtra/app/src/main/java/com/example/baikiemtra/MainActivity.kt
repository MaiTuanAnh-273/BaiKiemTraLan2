package com.example.baikiemtra

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    private lateinit var tvMaSV: TextView
    private lateinit var tvHoTen: TextView
    private lateinit var tvLop: TextView
    private lateinit var tvTuoi: TextView
    private lateinit var tvDiem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMaSV = findViewById(R.id.tvMaSV)
        tvHoTen = findViewById(R.id.tvHoTen)
        tvLop = findViewById(R.id.tvLop)
        tvTuoi = findViewById(R.id.tvTuoi)
        tvDiem = findViewById(R.id.tvDiem)
        val student = Student(
            maSinhVien = "2415141122125",
            hoTen = "Mai Tuấn Anh",
            lop = "126TLTTD01",
            tuoi = 20,
            diem = 8.5
        )
        tvMaSV.text = "Mã sinh viên: ${student.maSinhVien}"
        tvHoTen.text = "Họ tên: ${student.hoTen}"
        tvLop.text = "Lớp: ${student.lop}"
        tvTuoi.text = "Tuổi: ${student.tuoi}"
        tvDiem.text = "Điểm: ${student.diem}"
    }
}