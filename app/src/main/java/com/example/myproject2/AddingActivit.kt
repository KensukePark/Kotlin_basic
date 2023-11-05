package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import com.example.myproject2.databinding.ActivityAddingBinding
import com.example.myproject2.databinding.ActivityMainBinding

class AddingActivit : AppCompatActivity() {
    private lateinit var binding: ActivityAddingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val toolbarBody = binding.toolbar
        setSupportActionBar(toolbarBody)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarBody.title = "판매 등록"
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> { //뒤로 가기 버튼
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}