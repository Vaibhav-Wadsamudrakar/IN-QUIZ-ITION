package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        var score=intent.getIntExtra("score",0)
        val totalque=intent.getStringExtra("total size")

        Score.text="${score}/${totalque}"
        if (score < 2)
        {
            congo.text= "Tough Luck.Never mind :) "
        }
        if (score >=2 && score<=4)
        {
            congo.text="Keep it Up!!"
        }
        if (score ==5 )
        {
            congo.text="Clean Sweep!Cool!"
        }
        mainpage.setOnClickListener{
            startActivity(Intent(this@result,topicselectactivity::class.java))
            finish()
        }
        logoutbutton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@result,loginactivity::class.java))
            finish()
        }

    }
}