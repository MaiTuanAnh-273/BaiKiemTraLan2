package com.example.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var edtA: EditText
    private lateinit var edtB: EditText
    private lateinit var edtKQ: EditText
    private lateinit var btnTong: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
            edtA = findViewById(R.id.edtA)
            edtB = findViewById(R.id.edtB)
            edtKQ = findViewById(R.id.edtKQ)
            btnTong = findViewById(R.id.btnTong)

            edtKQ.isFocusable = false
            edtKQ.isClickable = false

            btnTong.setOnClickListener {
                val a = edtA.text.toString().trim()
                val b = edtB.text.toString().trim()

                if (a.isEmpty() || b.isEmpty()) {
                    Toast.makeText(
                        this,
                        "Vui lòng nhập đầy đủ số A và số B",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val soA = a.toDoubleOrNull()
                    val soB = b.toDoubleOrNull()

                    if (soA != null && soB != null) {
                        val tong = soA + soB
                        edtKQ.setText(tong.toString())
                    } else {
                        Toast.makeText(
                            this,
                            "Vui lòng nhập số hợp lệ",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
