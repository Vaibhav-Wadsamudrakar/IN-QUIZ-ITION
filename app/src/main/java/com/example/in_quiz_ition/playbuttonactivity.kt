package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_playbuttonactivity.*

class playbuttonactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playbuttonactivity)

        play.setOnClickListener {
            var intent= Intent(this,topicselectactivity::class.java)
            startActivity(intent)
        }






    }
}