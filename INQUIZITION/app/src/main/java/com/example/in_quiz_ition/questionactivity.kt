package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class questionactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)
        setdata.getqeustion()
        var demo=setdata.getqeustion()
    }
}