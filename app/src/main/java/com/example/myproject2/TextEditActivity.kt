package com.example.myproject2

import android.content.ContentValues.TAG
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

class TextEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        //editor.clear()
        editor.putString("now_id", "")
        editor.apply()
        setContentView(R.layout.activity_text_edit)
        BtnClick()
    }

    fun BtnClick() {
        val btn_regist = findViewById<Button>(R.id.btn_regist)
        btn_regist.setOnClickListener {
            val intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            val Edit_login_id = findViewById<EditText>(R.id.login_id)
            var id = Edit_login_id.text.toString()

            val Edit_login_pw = findViewById<EditText>(R.id.login_password)
            var pw = Edit_login_pw.text.toString()

            val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
            val id_prefs = prefs.getString(id, "")

            if(prefs.contains(id) && id_prefs == pw){
                Toast.makeText(this, "Welocme ${id}", Toast.LENGTH_SHORT).show()
                val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putString("now_id", id)
                editor.apply()
                val intent = Intent(this, UserPageActivity::class.java)
                startActivity(intent)
            }
            else{
                // 로그인 실패 다이얼로그 보여주기
                dialog("fail")
            }

        }
    }
    fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)
        if(type.equals("success")){
            Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "")
                }
            }
        }
        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}