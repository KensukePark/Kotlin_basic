package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FlagmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flagment)
        ClickBtns()
    }

    fun ClickBtns() {
        val btn_red = findViewById<Button>(R.id.btn_red)
        val btn_blue = findViewById<Button>(R.id.btn_blue)
        val btn_green = findViewById<Button>(R.id.btn_green)
        val btn_yellow = findViewById<Button>(R.id.btn_yellow)

        btn_red.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_one,RedFragment())
            fragmentTransaction.commit()
        }
        btn_blue.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_one,BlueFragment())
            fragmentTransaction.commit()
        }
        btn_yellow.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_one,YellowFragment())
            fragmentTransaction.commit()
        }
        btn_green.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_one,GreenFragment())
            fragmentTransaction.commit()
        }

    }
}