package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.WindowManager
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.myproject2.databinding.ActivityMainBinding
import kotlin.math.*

class CalculActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var calcul_string = ""
    var full_string = ""
    var spot_check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcul)
        btn_press()
    }
    fun show_string() {
        var string1 = findViewById<TextView>(R.id.string_1)
        string1.text = calcul_string
        var string2 = findViewById<TextView>(R.id.string_2)
        string2.text = ""
    }
    fun btn_press() {
        var btn_1 = findViewById<Button>(R.id.button_1)
        var btn_2 = findViewById<Button>(R.id.button_2)
        var btn_3 = findViewById<Button>(R.id.button_3)
        var btn_4 = findViewById<Button>(R.id.button_4)
        var btn_5 = findViewById<Button>(R.id.button_5)
        var btn_6 = findViewById<Button>(R.id.button_6)
        var btn_7 = findViewById<Button>(R.id.button_7)
        var btn_8 = findViewById<Button>(R.id.button_8)
        var btn_9 = findViewById<Button>(R.id.button_9)
        var btn_0 = findViewById<Button>(R.id.button_0)
        var btn_00 = findViewById<Button>(R.id.button_00)
        var btn_spot = findViewById<Button>(R.id.button_spot)
        var btn_equal = findViewById<Button>(R.id.button_equal)
        var btn_plus = findViewById<Button>(R.id.button_plus)
        var btn_minus = findViewById<Button>(R.id.button_minus)
        var btn_multi = findViewById<Button>(R.id.button_multi)
        var btn_devide = findViewById<Button>(R.id.button_devide)
        var btn_ce = findViewById<Button>(R.id.button_CE)
        var btn_c = findViewById<Button>(R.id.button_C)
        var btn_del = findViewById<Button>(R.id.button_del)
        btn_1.setOnClickListener {
            calcul_string = calcul_string + "1"
            show_string()
        }
        btn_2.setOnClickListener {
            calcul_string = calcul_string + "2"
            show_string()
        }
        btn_3.setOnClickListener {
            calcul_string = calcul_string + "3"
            show_string()
        }
        btn_4.setOnClickListener {
            calcul_string = calcul_string + "4"
            show_string()
        }
        btn_5.setOnClickListener {
            calcul_string = calcul_string + "5"
            show_string()
        }
        btn_6.setOnClickListener {
            calcul_string = calcul_string + "6"
            show_string()
        }
        btn_7.setOnClickListener {
            calcul_string = calcul_string + "7"
            show_string()
        }
        btn_8.setOnClickListener {
            calcul_string = calcul_string + "8"
            show_string()
        }
        btn_9.setOnClickListener {
            calcul_string = calcul_string + "9"
            show_string()
        }
        btn_0.setOnClickListener {
            if (calcul_string != "0") calcul_string = calcul_string + "0"
            show_string()
        }
        btn_00.setOnClickListener {
            if (calcul_string != "0") calcul_string = calcul_string + "00"
            show_string()
        }
        btn_spot.setOnClickListener {
            if (calcul_string != "" && spot_check == false) {
                calcul_string = calcul_string + "."
                spot_check = true
            }
            show_string()
        }
        btn_ce.setOnClickListener {
            calcul_string = ""
            show_string()
            spot_check = false
        }
        btn_c.setOnClickListener {
            calcul_string = ""
            show_string()
            spot_check = false
        }
        btn_del.setOnClickListener {
            if (calcul_string[calcul_string.length-1] == '.') spot_check = false
            calcul_string = calcul_string.substring(0,calcul_string.length-1)
            show_string()
        }
        btn_equal.setOnClickListener {
            if (calcul_string[calcul_string.length-1].isDigit() &&
                (calcul_string.contains("+") ||
                        calcul_string.contains("-") ||
                        calcul_string.contains("*") ||
                        calcul_string.contains("/"))) {
                var temp = calcul_string
                if (calcul_string.contains("+")) {
                    var num_one = calcul_string.split("+")[0].toDouble()
                    var num_two = calcul_string.split("+")[1].toDouble()
                    var result = num_one+num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString()
                    }
                    else calcul_string = (result.toInt()).toString()
                }
                else if (calcul_string.contains("-")) {
                    var num_one = calcul_string.split("-")[0].toDouble()
                    var num_two = calcul_string.split("-")[1].toDouble()
                    var result = num_one-num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString()
                    }
                    else calcul_string = (result.toInt()).toString()
                }
                else if (calcul_string.contains("*")) {
                    var num_one = calcul_string.split("*")[0].toDouble()
                    var num_two = calcul_string.split("*")[1].toDouble()
                    var result = num_one*num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString()
                    }
                    else calcul_string = (result.toInt()).toString()
                }
                else if (calcul_string.contains("/")) {
                    var num_one = calcul_string.split("/")[0].toDouble()
                    var num_two = calcul_string.split("/")[1].toDouble()
                    var result = num_one/num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString()
                    }
                    else calcul_string = (result.toInt()).toString()
                }
                var string1 = findViewById<TextView>(R.id.string_1)
                string1.text = temp
                var string2 = findViewById<TextView>(R.id.string_2)
                string2.text = calcul_string
                spot_check = false
            }
        }
        btn_plus.setOnClickListener {
            if (calcul_string[calcul_string.length-1].isDigit() &&
                (calcul_string.contains("+") ||
                        calcul_string.contains("-") ||
                        calcul_string.contains("*") ||
                        calcul_string.contains("/"))) {
                if (calcul_string.contains("+")) {
                    var num_one = calcul_string.split("+")[0].toDouble()
                    var num_two = calcul_string.split("+")[1].toDouble()
                    var result = num_one+num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "+"
                    }
                    else calcul_string = (result.toInt()).toString() + "+"
                }
                else if (calcul_string.contains("-")) {
                    var num_one = calcul_string.split("-")[0].toDouble()
                    var num_two = calcul_string.split("-")[1].toDouble()
                    var result = num_one-num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "+"
                    }
                    else calcul_string = (result.toInt()).toString() + "+"
                }
                else if (calcul_string.contains("*")) {
                    var num_one = calcul_string.split("*")[0].toDouble()
                    var num_two = calcul_string.split("*")[1].toDouble()
                    var result = num_one*num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "+"
                    }
                    else calcul_string = (result.toInt()).toString() + "+"
                }
                else if (calcul_string.contains("/")) {
                    var num_one = calcul_string.split("/")[0].toDouble()
                    var num_two = calcul_string.split("/")[1].toDouble()
                    var result = num_one/num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "+"
                    }
                    else calcul_string = (result.toInt()).toString() + "+"
                }
                show_string()
                spot_check = false
            }
            else {
                if (calcul_string[calcul_string.length-1].isDigit()) calcul_string = calcul_string + "+"
                else if (
                    calcul_string[calcul_string.length-1] == '+' ||
                    calcul_string[calcul_string.length-1] == '-' ||
                    calcul_string[calcul_string.length-1] == '*' ||
                    calcul_string[calcul_string.length-1] == '/') calcul_string = calcul_string.substring(0,calcul_string.length-1) + "+"
            }
            show_string()
            spot_check = false
        }
        btn_minus.setOnClickListener {
            if (calcul_string[calcul_string.length-1].isDigit() &&
                (calcul_string.contains("+") ||
                        calcul_string.contains("-") ||
                        calcul_string.contains("*") ||
                        calcul_string.contains("/"))) {
                if (calcul_string.contains("+")) {
                    var num_one = calcul_string.split("+")[0].toDouble()
                    var num_two = calcul_string.split("+")[1].toDouble()
                    var result = num_one+num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "-"
                    }
                    else calcul_string = (result.toInt()).toString() + "-"
                }
                else if (calcul_string.contains("-")) {
                    var num_one = calcul_string.split("-")[0].toDouble()
                    var num_two = calcul_string.split("-")[1].toDouble()
                    var result = num_one-num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "-"
                    }
                    else calcul_string = (result.toInt()).toString() + "-"
                }
                else if (calcul_string.contains("*")) {
                    var num_one = calcul_string.split("*")[0].toDouble()
                    var num_two = calcul_string.split("*")[1].toDouble()
                    var result = num_one*num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "-"
                    }
                    else calcul_string = (result.toInt()).toString() + "-"
                }
                else if (calcul_string.contains("/")) {
                    var num_one = calcul_string.split("/")[0].toDouble()
                    var num_two = calcul_string.split("/")[1].toDouble()
                    var result = num_one/num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "-"
                    }
                    else calcul_string = (result.toInt()).toString() + "-"
                }
                show_string()
                spot_check = false
            }
            else {
                if (calcul_string[calcul_string.length-1].isDigit()) calcul_string = calcul_string + "-"
                else if (
                    calcul_string[calcul_string.length-1] == '+' ||
                    calcul_string[calcul_string.length-1] == '-' ||
                    calcul_string[calcul_string.length-1] == '*' ||
                    calcul_string[calcul_string.length-1] == '/') calcul_string = calcul_string.substring(0,calcul_string.length-1) + "-"

            }
            show_string()
            spot_check = false
        }
        btn_multi.setOnClickListener {
            if (calcul_string[calcul_string.length-1].isDigit() &&
                (calcul_string.contains("+") ||
                        calcul_string.contains("-") ||
                        calcul_string.contains("*") ||
                        calcul_string.contains("/"))) {
                if (calcul_string.contains("+")) {
                    var num_one = calcul_string.split("+")[0].toDouble()
                    var num_two = calcul_string.split("+")[1].toDouble()
                    var result = num_one+num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "*"
                    }
                    else calcul_string = (result.toInt()).toString() + "*"
                }
                else if (calcul_string.contains("-")) {
                    var num_one = calcul_string.split("-")[0].toDouble()
                    var num_two = calcul_string.split("-")[1].toDouble()
                    var result = num_one-num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "*"
                    }
                    else calcul_string = (result.toInt()).toString() + "*"
                }
                else if (calcul_string.contains("*")) {
                    var num_one = calcul_string.split("*")[0].toDouble()
                    var num_two = calcul_string.split("*")[1].toDouble()
                    var result = num_one*num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "*"
                    }
                    else calcul_string = (result.toInt()).toString() + "*"
                }
                else if (calcul_string.contains("/")) {
                    var num_one = calcul_string.split("/")[0].toDouble()
                    var num_two = calcul_string.split("/")[1].toDouble()
                    var result = num_one/num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "*"
                    }
                    else calcul_string = (result.toInt()).toString() + "*"
                }
                show_string()
                spot_check = false
            }
            else {
                if (calcul_string[calcul_string.length-1].isDigit()) calcul_string = calcul_string + "*"
                else if (
                    calcul_string[calcul_string.length-1] == '+' ||
                    calcul_string[calcul_string.length-1] == '-' ||
                    calcul_string[calcul_string.length-1] == '*' ||
                    calcul_string[calcul_string.length-1] == '/') calcul_string = calcul_string.substring(0,calcul_string.length-1) + "*"
            }
            show_string()
            spot_check = false
        }
        btn_devide.setOnClickListener {
            if (calcul_string[calcul_string.length-1].isDigit() &&
                (calcul_string.contains("+") ||
                        calcul_string.contains("-") ||
                        calcul_string.contains("*") ||
                        calcul_string.contains("/"))) {
                if (calcul_string.contains("+")) {
                    var num_one = calcul_string.split("+")[0].toDouble()
                    var num_two = calcul_string.split("+")[1].toDouble()
                    var result = num_one+num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "/"
                    }
                    else calcul_string = (result.toInt()).toString() + "/"
                }
                else if (calcul_string.contains("-")) {
                    var num_one = calcul_string.split("-")[0].toDouble()
                    var num_two = calcul_string.split("-")[1].toDouble()
                    var result = num_one-num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "/"
                    }
                    else calcul_string = (result.toInt()).toString() + "/"
                }
                else if (calcul_string.contains("*")) {
                    var num_one = calcul_string.split("*")[0].toDouble()
                    var num_two = calcul_string.split("*")[1].toDouble()
                    var result = num_one*num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "/"
                    }
                    else calcul_string = (result.toInt()).toString() + "/"
                }
                else if (calcul_string.contains("/")) {
                    var num_one = calcul_string.split("/")[0].toDouble()
                    var num_two = calcul_string.split("/")[1].toDouble()
                    var result = num_one/num_two
                    if (result - floor(result) > 0) {
                        calcul_string = (result).toString() + "/"
                    }
                    else calcul_string = (result.toInt()).toString() + "/"
                }
                show_string()
                spot_check = false
            }
            else {
                if (calcul_string[calcul_string.length-1].isDigit()) calcul_string = calcul_string + "/"
                else if (
                    calcul_string[calcul_string.length-1] == '+' ||
                    calcul_string[calcul_string.length-1] == '-' ||
                    calcul_string[calcul_string.length-1] == '*' ||
                    calcul_string[calcul_string.length-1] == '/') calcul_string = calcul_string.substring(0,calcul_string.length-1) + "/"
            }
            show_string()
            spot_check = false
        }
    }
}