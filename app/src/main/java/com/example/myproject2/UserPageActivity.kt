package com.example.myproject2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.myproject2.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.w3c.dom.Text
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)
        defualtSet()
        btn_click()
    }
    fun defualtSet() {
        var UserList = arrayListOf<User>()
        val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
        val now_id = prefs.getString("now_id", "")
        var id : String = now_id.toString()
        val text_main = findViewById<TextView>(R.id.user_welcome)
        text_main.text = "Home"
        if (!prefs.contains("item_list")) {
            val editor = prefs.edit()
            var temp_arr : ArrayList<String> = ArrayList()
            temp_arr.add(0, "hellow")
            var temp_jsonArr = JSONArray()
            for(i in temp_arr){
                temp_jsonArr.put(i)
            }
            var temp_result = temp_jsonArr.toString()
            editor.putString("item_list", temp_result)
            editor.apply()
            val text_two = findViewById<TextView>(R.id.textView_two)
            text_two.text = "비어있음"
        }
        else {
            val getData = prefs.getString("item_list", "")

            var ArrJson = JSONArray(getData)
            var resultArr : ArrayList<String> = ArrayList()
            if (ArrJson.length() > 1) {
                var idx = 0
                for(i in ArrJson.length()-1 downTo   1 ){
                    resultArr.add(ArrJson.optString(i))
                    UserList.add(User(R.drawable.chunsik, resultArr[idx].split("@")[0], resultArr[idx].split("@")[1], resultArr[idx].split("@")[2]))
                    idx++
                }
                val text_two = findViewById<TextView>(R.id.textView_two)
                text_two.text = "${resultArr.size}"
            }
            else {
                val text_two = findViewById<TextView>(R.id.textView_two)
                text_two.text = "Empty"
            }

        }
        val Adapter = UserAdapter(this, UserList)
        val listview = findViewById<ListView>(R.id.listView)
        listview.adapter = Adapter

        listview.onItemClickListener = AdapterView.OnItemClickListener {
                parent,
                view,
                position,
                id -> val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }

    fun btn_click() {
        val btn_float = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        btn_float.setOnClickListener {
            var intent = Intent(this, AddingActivit::class.java)
            startActivity(intent)
//            val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
//            val now_id = prefs.getString("now_id", "")
//            val editor = prefs.edit()
//            val getData = prefs.getString("item_list", "")
//            var ArrJson = JSONArray(getData)
//            var resultArr : ArrayList<String> = ArrayList()
//            if (ArrJson.length() != 0) {
//                for(i in 0 until  ArrJson.length()){
//                    resultArr.add(ArrJson.optString(i))
//                }
//            }
//            val length = 10
//            val randomTitle = getRandomString(length)
//            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
//            val current = LocalDateTime.now().format(formatter)
//            resultArr.add(now_id + '@' + randomTitle + '@' + current.toString())
//            var jsonArr_save = JSONArray()
//            for(i in resultArr) jsonArr_save.put(i)
//            var result = jsonArr_save.toString()
//            editor.putString("item_list", result)
//            editor.apply()
//            //val intent = Intent(this, UserPageActivity::class.java)
//            //startActivity(intent)
//            defualtSet()
        }
    }

    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}