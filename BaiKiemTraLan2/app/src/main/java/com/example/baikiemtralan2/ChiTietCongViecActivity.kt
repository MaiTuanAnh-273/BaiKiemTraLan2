package com.example.baikiemtralan2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvChiTiet: TextView
    private lateinit var btnHoanThanh: Button
    private lateinit var btnChinhSua: Button

    private var congViec: CongViec? = null

    private val chinhSuaLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { ketQua ->

            if (ketQua.resultCode == RESULT_OK) {
                val data = ketQua.data

                val cvMoi = if (Build.VERSION.SDK_INT >= 33) {
                    data?.getSerializableExtra(
                        "CONG_VIEC",
                        CongViec::class.java
                    )
                } else {
                    @Suppress("DEPRECATION")
                    (data?.getSerializableExtra("CONG_VIEC")
                            as? CongViec)
                }

                if (cvMoi != null) {
                    congViec = cvMoi
                    hienThiCongViec()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTiet = findViewById(R.id.tvChiTiet)
        btnHoanThanh = findViewById(R.id.btnHoanThanh)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        congViec = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(
                "CONG_VIEC",
                CongViec::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            (intent.getSerializableExtra("CONG_VIEC")
                    as? CongViec)
        }

        if (congViec == null) {
            Toast.makeText(
                this,
                "Không nhận được thông tin công việc",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        hienThiCongViec()

        btnHoanThanh.setOnClickListener {
            val cv = congViec ?: return@setOnClickListener

            cv.trangThai =
                if (cv.trangThai == "Đã hoàn thành") {
                    "Chưa hoàn thành"
                } else {
                    "Đã hoàn thành"
                }

            hienThiCongViec()
        }

        btnChinhSua.setOnClickListener {
            val cv = congViec ?: return@setOnClickListener

            val intent = Intent(
                this,
                ChinhSuaCongViecActivity::class.java
            )

            intent.putExtra("CONG_VIEC", cv)

            chinhSuaLauncher.launch(intent)
        }
    }

    private fun hienThiCongViec() {
        tvChiTiet.text = congViec?.thongTinCongViec()

        btnHoanThanh.text =
            if (congViec?.trangThai == "Đã hoàn thành") {
                "Đánh dấu chưa hoàn thành"
            } else {
                "Đánh dấu hoàn thành"
            }
    }
}