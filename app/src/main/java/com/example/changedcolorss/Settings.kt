package com.example.changedcolorss

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener


class Settings : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var go_back : Button
    lateinit var change_color : Button
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sh1 = getSharedPreferences("background", Context.MODE_APPEND)
        val color = sh1.getInt("color", 0)
        window.decorView.setBackgroundColor(color)


        change_color = findViewById<Button>(R.id.change_color)
        go_back = findViewById<Button>(R.id.go_back)

        go_back.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java))
        }

        change_color.setOnClickListener{
            val colorPicker = ColorPicker(this)
            colorPicker.show()
            colorPicker.setOnChooseColorListener(object : OnChooseColorListener {
                override fun onChooseColor(position: Int, color: Int) { // put code
                    val sh: SharedPreferences = getSharedPreferences("background", Context.MODE_PRIVATE)
                    val myEdit = sh.edit()
                    myEdit.putInt("color", color)
                    myEdit.apply()
                    window.decorView.setBackgroundColor(color)
                }

                override fun onCancel() { // put code
                }
            })
        }


    }
}
