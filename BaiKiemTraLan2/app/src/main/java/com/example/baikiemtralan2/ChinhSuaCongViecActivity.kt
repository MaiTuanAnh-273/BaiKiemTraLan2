
package com.example.baikiemtralan2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var btnLuu: Button

    private var congViec: CongViec? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTa = findViewById(R.id.edtMoTa)
        btnLuu = findViewById(R.id.btnLuu)

        congViec = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(
                "CONG_VIEC",
                CongViec::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            (intent.getSerializableExtra("CONG_VIEC") as? CongViec)
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

        edtTenCongViec.setText(congViec?.tenCongViec)
        edtMoTa.setText(congViec?.moTa)

        btnLuu.setOnClickListener {
            val tenMoi = edtTenCongViec.text.toString().trim()
            val moTaMoi = edtMoTa.text.toString().trim()

            if (tenMoi.isEmpty()) {
                edtTenCongViec.error =
                    "Vui lòng nhập tên công việc"
                edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            val cvCu = congViec ?: return@setOnClickListener

            val congViecMoi = CongViec(
                tenCongViec = tenMoi,
                moTa = moTaMoi,
                trangThai = cvCu.trangThai
            )

            val ketQua = Intent()
            ketQua.putExtra("CONG_VIEC", congViecMoi)

            setResult(RESULT_OK, ketQua)
            finish()
        }
    }
}
