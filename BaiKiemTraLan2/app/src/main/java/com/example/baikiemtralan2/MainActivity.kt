
package com.example.baikiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSinhVien =
            findViewById<TextView>(R.id.tvSinhVien)

        val edtTenCongViec =
            findViewById<EditText>(R.id.edtTenCongViec)

        val edtMoTa =
            findViewById<EditText>(R.id.edtMoTa)

        val btnTaoCongViec =
            findViewById<Button>(R.id.btnTaoCongViec)

        val btnXemDanhSach =
            findViewById<Button>(R.id.btnXemDanhSach)

        tvSinhVien.text =
            "Họ tên: Mai Tuấn Anh\n" +
                    "Mã sinh viên: 2415141122125\n" +
                    "Lớp HP: 126TLTTD01"

        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            if (ten.isEmpty()) {
                edtTenCongViec.error =
                    "Vui lòng nhập tên công việc"
                edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            // Tạo Intent để mở màn hình chi tiết
            val intent = Intent(
                this,
                ChiTietCongViecActivity::class.java
            )

            // Truyền tên và mô tả công việc
            intent.putExtra("TEN_CONG_VIEC", ten)
            intent.putExtra("MO_TA_CONG_VIEC", moTa)

            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            Toast.makeText(
                this,
                "Chức năng danh sách sẽ thực hiện ở phần tiếp theo",
                Toast.LENGTH_SHORT
            ).show()
        }
        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            if (ten.isEmpty()) {
                edtTenCongViec.error = "Vui lòng nhập tên công việc"
                return@setOnClickListener
            }

            val intent = Intent(
                this,
                ChiTietCongViecActivity::class.java
            )

            intent.putExtra("TEN_CONG_VIEC", ten)
            intent.putExtra("MO_TA_CONG_VIEC", moTa)

            startActivity(intent)
        }
    }
}
