package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.myproject2.databinding.ActivityAddingBinding
import com.example.myproject2.databinding.ActivityMainBinding

class AddingActivit : AppCompatActivity() {
    private lateinit var binding: ActivityAddingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)
        val toolbarBody = binding.toolbar
        setSupportActionBar(toolbarBody)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarBody.title = "판매 등록"
    }
}