package com.example.baikiemtralan2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var spMucDoUuTien: Spinner
    private lateinit var btnLuu: Button

    private var congViec: CongViec? = null

    private val danhSachUuTien =
        listOf("Thấp", "Trung bình", "Cao")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTenCongViec = findViewById(R.id.edtTenCongViecSua)
        edtMoTa = findViewById(R.id.edtMoTaSua)
        spMucDoUuTien = findViewById(R.id.spMucDoUuTien)
        btnLuu = findViewById(R.id.btnLuu)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            danhSachUuTien
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spMucDoUuTien.adapter = adapter

        congViec = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(
                "CONG_VIEC",
                CongViec::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            (intent.getSerializableExtra("CONG_VIEC") as? CongViec)
        }

        val cvCu = congViec

        if (cvCu == null) {
            Toast.makeText(
                this,
                "Không nhận được thông tin công việc",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        // Hiển thị dữ liệu hiện tại
        edtTenCongViec.setText(cvCu.tenCongViec)
        edtMoTa.setText(cvCu.moTa)

        // Chọn mức ưu tiên hiện tại
        val viTriUuTien =
            danhSachUuTien.indexOf(cvCu.mucDoUuTien)

        spMucDoUuTien.setSelection(
            if (viTriUuTien >= 0) viTriUuTien else 1
        )

        btnLuu.setOnClickListener {
            val tenMoi =
                edtTenCongViec.text.toString().trim()

            val moTaMoi =
                edtMoTa.text.toString().trim()

            // Kiểm tra tên rỗng hoặc chỉ chứa khoảng trắng
            if (tenMoi.isEmpty()) {
                edtTenCongViec.error =
                    "Tên công việc không được để trống"

                edtTenCongViec.requestFocus()

                Toast.makeText(
                    this,
                    "Vui lòng nhập tên công việc",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val mucDoMoi =
                spMucDoUuTien.selectedItem.toString()

            // Giữ nguyên mã và trạng thái cũ
            val congViecMoi = cvCu.copy(
                tenCongViec = tenMoi,
                moTa = moTaMoi,
                mucDoUuTien = mucDoMoi
            )

            // Trả đối tượng mới về màn hình chi tiết
            val ketQua = Intent().apply {
                putExtra("CONG_VIEC", congViecMoi)
            }

            setResult(RESULT_OK, ketQua)
            finish()
        }
    }
}