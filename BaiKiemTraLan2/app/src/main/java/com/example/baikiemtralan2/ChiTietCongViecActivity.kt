package com.example.baikiemtralan2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tvTen = findViewById<TextView>(R.id.tvTenCongViec)
        val tvMoTa = findViewById<TextView>(R.id.tvMoTaCongViec)

        val ten = intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        val moTa = intent.getStringExtra("MO_TA_CONG_VIEC") ?: ""

        tvTen.text = "Tên công việc: $ten"
        tvMoTa.text = "Mô tả công việc: $moTa"
    }
}