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
    private lateinit var congViec: CongViec

    private val suaCongViecLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { ketQua ->

            if (ketQua.resultCode == Activity.RESULT_OK) {
                val data = ketQua.data

                if (data != null) {
                    congViec.tenCongViec =
                        data.getStringExtra("TEN_CONG_VIEC") ?: ""

                    congViec.moTa =
                        data.getStringExtra("MO_TA_CONG_VIEC") ?: ""

                    hienThiCongViec()
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

        // Nhận đối tượng CongViec từ MainActivity
        congViec = intent.getSerializableExtra("CONG_VIEC") as? CongViec
            ?: CongViec("", "")

        hienThiCongViec()

        btnChinhSua.setOnClickListener {
            val intentSua = Intent(
                this,
                ChinhSuaCongViecActivity::class.java
            )

            intentSua.putExtra(
                "TEN_CONG_VIEC",
                congViec.tenCongViec
            )

            intentSua.putExtra(
                "MO_TA_CONG_VIEC",
                congViec.moTa
            )

            suaCongViecLauncher.launch(intentSua)
        }
    }

    private fun hienThiCongViec() {
        val thongTin = congViec.thongTinCongViec().lines()

        tvTen.text = thongTin[0]
        tvMoTa.text = thongTin.drop(1).joinToString("\n")
    }
}