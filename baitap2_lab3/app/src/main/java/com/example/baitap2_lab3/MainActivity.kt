package com.example.baitap2_lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChiTiet = findViewById<Button>(R.id.btnChiTiet)

        btnChiTiet.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("MASV", "2415141122125")
            intent.putExtra("HOTEN", "Mai Tuấn Anh")
            intent.putExtra("LOP", "126TLTTD01")

            startActivity(intent)
        }
    }
}