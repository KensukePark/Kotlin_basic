package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TextEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_edit)
    }

    fun BtnClick() {
        val btn_regist = findViewById<Button>(R.id.btn_regist)
        btn_regist.setOnClickListener {

        }
        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {

        }
    }
}