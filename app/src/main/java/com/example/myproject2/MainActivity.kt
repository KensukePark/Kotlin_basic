package com.example.myproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MoveToEdit();
    }

    fun MoveToEdit() {
        val btn_one = findViewById<Button>(R.id.btn_to_TextEdit)
        btn_one.setOnClickListener {
            val intent = Intent(this, TextEditActivity::class.java)
            startActivity(intent)
        }
        val btn_two = findViewById<Button>(R.id.btn_to_Flagment)
        btn_two.setOnClickListener {
            val intent = Intent(this, FlagmentActivity::class.java)
            startActivity(intent)
        }
    }
}