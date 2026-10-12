package com.example.baikiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTen: TextView
    private lateinit var tvMoTa: TextView

    // Đăng ký Activity Result API
    private val suaCongViecLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { ketQua ->

            if (ketQua.resultCode == Activity.RESULT_OK) {
                val data = ketQua.data

                if (data != null) {
                    val tenMoi =
                        data.getStringExtra("TEN_CONG_VIEC") ?: ""
                    val moTaMoi =
                        data.getStringExtra("MO_TA_CONG_VIEC") ?: ""

                    // Cập nhật thông tin trên màn hình chi tiết
                    tvTen.text = "Tên công việc: $tenMoi"
                    tvMoTa.text = "Mô tả công việc: $moTaMoi"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTen = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTaCongViec)

        val btnChinhSua =
            findViewById<Button>(R.id.btnChinhSua)

        // Nhận dữ liệu từ MainActivity
        val ten = intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        val moTa = intent.getStringExtra("MO_TA_CONG_VIEC") ?: ""

        tvTen.text = "Tên công việc: $ten"
        tvMoTa.text = "Mô tả công việc: $moTa"

        btnChinhSua.setOnClickListener {
            val intentSua = Intent(
                this,
                ChinhSuaCongViecActivity::class.java
            )

            // Gửi dữ liệu hiện tại sang màn hình chỉnh sửa
            intentSua.putExtra("TEN_CONG_VIEC", tenHienTai())
            intentSua.putExtra("MO_TA_CONG_VIEC", moTaHienTai())

            suaCongViecLauncher.launch(intentSua)
        }
    }

    private fun tenHienTai(): String {
        return tvTen.text.toString().removePrefix("Tên công việc: ")
    }

    private fun moTaHienTai(): String {
        return tvMoTa.text.toString().removePrefix("Mô tả công việc: ")
    }
}