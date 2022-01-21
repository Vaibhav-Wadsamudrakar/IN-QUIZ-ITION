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
        val score=intent.getStringExtra("score")
        val totalque=intent.getStringExtra("total size")

        congo.text="Congratulations !!"
        Score.text="${score}/${totalque}"
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