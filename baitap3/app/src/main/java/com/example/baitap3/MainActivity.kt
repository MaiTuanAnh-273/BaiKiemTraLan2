package com.example.baitap3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var tvMaSinhVien: TextView
    private lateinit var tvHoTen: TextView
    private lateinit var tvLop: TextView
    private lateinit var tvNganh: TextView
    private lateinit var tvGpa: TextView
    private lateinit var btnChinhSua: Button

    private var student = Student(
        maSinhVien = "2415141122125",
        hoTen = "Mai Tuấn Anh",
        lop = "24SK1",
        nganh = "Sư Phạm Công Nghiệp",
        gpa = 8.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvMaSinhVien = findViewById(R.id.tvMaSinhVien)
        tvHoTen = findViewById(R.id.tvHoTen)
        tvLop = findViewById(R.id.tvLop)
        tvNganh = findViewById(R.id.tvNganh)
        tvGpa = findViewById(R.id.tvGpa)

        btnChinhSua = findViewById(R.id.btnChinhSua)

        hienThiThongTin()

        btnChinhSua.setOnClickListener {

            val intent = Intent(this, EditProfileActivity::class.java)

            intent.putExtra("STUDENT", student)

            startActivityForResult(intent, 100)
        }
    }

    private fun hienThiThongTin() {

        tvMaSinhVien.text = "Ma sinh vien: ${student.maSinhVien}"

        tvHoTen.text = "Ho ten: ${student.hoTen}"

        tvLop.text = "Lop: ${student.lop}"

        tvNganh.text = "Nganh: ${student.nganh}"

        tvGpa.text = "GPA: ${student.gpa}"
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {

            val studentMoi =
                data?.getSerializableExtra("STUDENT") as? Student

            if (studentMoi != null) {

                student = studentMoi

                hienThiThongTin()
            }
        }
    }
}