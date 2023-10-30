package com.example.myproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)
        //위의 binding부터 setContentView까지의 세줄로 view binding 하는 코드. binding.btn~~ 로 사용 가능
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
        val btn_thr = findViewById<Button>(R.id.btn_to_Cal)
        btn_thr.setOnClickListener {
            val intent = Intent(this, CalculActivity::class.java)
            startActivity(intent)
        }

    }
}