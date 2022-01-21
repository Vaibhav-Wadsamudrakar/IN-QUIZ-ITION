package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName=intent.getStringExtra(setdata.name)
        val score=intent.getStringExtra(setdata.score)
        val totalque=intent.getStringExtra("total size")

        congo.text="Congratulations ${userName} !!"
        Score.text="${score}/${totalque}"
        mainpage.setOnClickListener{
            startActivity(Intent(this@result,MainActivity::class.java))
            finish()
        }

    }
}