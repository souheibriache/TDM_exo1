package com.example.changedcolorss

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var settings : Button
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sh1 = getSharedPreferences("background", Context.MODE_APPEND)
        val color = sh1.getInt("color", 0)
        window.decorView.setBackgroundColor(color)


        settings = findViewById<Button>(R.id.settings_btn)

        settings.setOnClickListener{
            startActivity(Intent(this , Settings::class.java))
        }

    }


    @SuppressLint("WrongConstant")
    override fun onResume() {
        super.onResume()
        val sh1 = getSharedPreferences("background", Context.MODE_APPEND)

        val s2 = sh1.getInt("color", 0)
        window.decorView.setBackgroundColor(s2)




    }

    override fun onPause() {
        super.onPause()
        val sh: SharedPreferences = getSharedPreferences("myOwnShared", Context.MODE_PRIVATE)
        val myEdit = sh.edit()

        myEdit.apply()
    }
}
