package com.example.baitap3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditProfileActivity : Activity() {

    private lateinit var edtHoTen: EditText
    private lateinit var edtLop: EditText
    private lateinit var edtNganh: EditText
    private lateinit var edtGpa: EditText

    private lateinit var btnLuu: Button
    private lateinit var btnHuy: Button

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)

        edtHoTen = findViewById(R.id.edtHoTen)
        edtLop = findViewById(R.id.edtLop)
        edtNganh = findViewById(R.id.edtNganh)
        edtGpa = findViewById(R.id.edtGpa)

        btnLuu = findViewById(R.id.btnLuu)
        btnHuy = findViewById(R.id.btnHuy)

        student =
            intent.getSerializableExtra("STUDENT") as? Student

        if (student != null) {

            edtHoTen.setText(student!!.hoTen)

            edtLop.setText(student!!.lop)

            edtNganh.setText(student!!.nganh)

            edtGpa.setText(student!!.gpa.toString())
        }

        btnLuu.setOnClickListener {

            luuThongTin()
        }

        btnHuy.setOnClickListener {

            finish()
        }
    }

    private fun luuThongTin() {

        val hoTen = edtHoTen.text.toString().trim()

        val lop = edtLop.text.toString().trim()

        val nganh = edtNganh.text.toString().trim()

        val gpaText = edtGpa.text.toString().trim()

        if (hoTen.isEmpty()) {

            edtHoTen.error = "Vui long nhap ho ten"

            edtHoTen.requestFocus()

            return
        }

        if (lop.isEmpty()) {

            edtLop.error = "Vui long nhap lop"

            edtLop.requestFocus()

            return
        }

        if (nganh.isEmpty()) {

            edtNganh.error = "Vui long nhap nganh"

            edtNganh.requestFocus()

            return
        }

        if (gpaText.isEmpty()) {

            edtGpa.error = "Vui long nhap GPA"

            edtGpa.requestFocus()

            return
        }

        val gpa = gpaText.toDoubleOrNull()

        if (gpa == null || gpa < 0 || gpa > 10) {

            edtGpa.error = "GPA phai tu 0 den 10"

            edtGpa.requestFocus()

            return
        }

        val studentMoi = Student(

            maSinhVien = student?.maSinhVien ?: "",

            hoTen = hoTen,

            lop = lop,

            nganh = nganh,

            gpa = gpa
        )

        val resultIntent = Intent()

        resultIntent.putExtra("STUDENT", studentMoi)

        setResult(RESULT_OK, resultIntent)

        Toast.makeText(
            this,
            "Da luu thong tin sinh vien",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }
}