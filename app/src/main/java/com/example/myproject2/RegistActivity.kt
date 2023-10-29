package com.example.myproject2

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class RegistActivity : AppCompatActivity() {
    val TAG: String = "Register"
    var isExistBlank = false
    var isPWSame = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        click_regist()
    }

    fun click_regist() {
        val btn_regist = findViewById<Button>(R.id.btn_register)
        btn_regist.setOnClickListener {
            Log.d(TAG, "회원가입 버튼 클릭")
            val edit_id = findViewById<EditText>(R.id.regist_id)
            val id = edit_id.text.toString()

            val edit_pw = findViewById<EditText>(R.id.regist_pass)
            val pw = edit_pw.text.toString()

            val edit_pwre = findViewById<EditText>(R.id.regist_pass_re)
            val pwre = edit_pwre.text.toString()

            if(id.isEmpty() || pw.isEmpty() || pwre.isEmpty()){
                isExistBlank = true
            }
            else{
                if(pw == pwre){
                    isPWSame = true
                }
            }
            if(!isExistBlank && isPWSame){
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
                val prefs = sharedPreference.edit()
                prefs.putString(id, pw)
                prefs.apply()

                val intent = Intent(this, TextEditActivity::class.java)
                startActivity(intent)
            }
            else{
                if(isExistBlank){
                    dialog("empty")
                }
                else if(!isPWSame){
                    dialog("inequal")
                }
            }
        }
    }
    fun dialog(type: String){
        val dialog = AlertDialog.Builder(this)
        if(type.equals("empty")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("아이디와 패스워드를 모두 입력하세요.")
        }
        else if(type.equals("inequal")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("비밀번호가 일치하지 않습니다.")
        }

        val dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "다이얼로그")
                }
            }
        }
        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}