package com.example.baitap2_lab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvMaSV = findViewById<TextView>(R.id.tvMaSV)
        val tvHoTen = findViewById<TextView>(R.id.tvHoTen)
        val tvLop = findViewById<TextView>(R.id.tvLop)
        val btnQuayLai = findViewById<Button>(R.id.btnQuayLai)

        val maSV = intent.getStringExtra("MASV")
        val hoTen = intent.getStringExtra("HOTEN")
        val lop = intent.getStringExtra("LOP")

        tvMaSV.text = "Mã SV: $maSV"
        tvHoTen.text = "Họ tên: $hoTen"
        tvLop.text = "Lớp: $lop"

        btnQuayLai.setOnClickListener {
            finish()
        }
    }
}