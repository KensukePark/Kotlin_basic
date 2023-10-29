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
        text_main.text = "${now_id}'s Page"
        if (!prefs.contains("${now_id}_list")) {
            val editor = prefs.edit()
            var temp_arr : ArrayList<String> = ArrayList()
            temp_arr.add(0, "hellow")
            var temp_jsonArr = JSONArray()
            for(i in temp_arr){
                temp_jsonArr.put(i)
            }
            var temp_result = temp_jsonArr.toString()
            editor.putString("${now_id}_list", temp_result)
            editor.apply()
            val text_two = findViewById<TextView>(R.id.textView_two)
            text_two.text = "비어있음"
        }
        else {
            val getData = prefs.getString("${now_id}_list", "")

            var ArrJson = JSONArray(getData)
            var resultArr : ArrayList<String> = ArrayList()
            if (ArrJson.length() != 0) {
                for(i in 0 until  ArrJson.length()){
                    resultArr.add(ArrJson.optString(i))
                    UserList.add(User(R.drawable.chunsik, id, resultArr[i]))
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
            val prefs = getSharedPreferences("file name", Context.MODE_PRIVATE)
            val now_id = prefs.getString("now_id", "")
            val editor = prefs.edit()
            val getData = prefs.getString("${now_id}_list", "")
            var ArrJson = JSONArray(getData)
            var resultArr : ArrayList<String> = ArrayList()
            if (ArrJson.length() != 0) {
                for(i in 0 until  ArrJson.length()){
                    resultArr.add(ArrJson.optString(i))
                }
            }
            resultArr.add(resultArr.size.toString())
            var jsonArr_save = JSONArray()
            for(i in resultArr) jsonArr_save.put(i)
            var result = jsonArr_save.toString()
            editor.putString("${now_id}_list", result)
            editor.apply()
            //val intent = Intent(this, UserPageActivity::class.java)
            //startActivity(intent)
            defualtSet()
        }
    }
}