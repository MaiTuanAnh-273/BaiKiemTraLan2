package com.example.baikiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val edtTen = findViewById<EditText>(R.id.edtTenCongViecSua)
        val edtMoTa = findViewById<EditText>(R.id.edtMoTaSua)
        val btnLuu = findViewById<Button>(R.id.btnLuu)

        // Nhận dữ liệu hiện tại từ màn hình chi tiết
        edtTen.setText(intent.getStringExtra("TEN_CONG_VIEC") ?: "")
        edtMoTa.setText(intent.getStringExtra("MO_TA_CONG_VIEC") ?: "")

        btnLuu.setOnClickListener {
            val ten = edtTen.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            if (ten.isEmpty()) {
                edtTen.error = "Vui lòng nhập tên công việc"
                return@setOnClickListener
            }

            // Đóng gói dữ liệu để trả về màn hình chi tiết
            val ketQua = Intent()
            ketQua.putExtra("TEN_CONG_VIEC", ten)
            ketQua.putExtra("MO_TA_CONG_VIEC", moTa)

            setResult(Activity.RESULT_OK, ketQua)
            finish()
        }
    }
}