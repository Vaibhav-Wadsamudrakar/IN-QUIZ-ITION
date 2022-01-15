package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_topicselectactivity.*


class topicselectactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topicselectactivity)

        topic1.setOnClickListener{
            var intent=Intent(this,questionactivity::class.java)
            intent.putExtra("topic","1")
            startActivity(intent)
            finish()
        }

        topic2.setOnClickListener{
            var intent=Intent(this,questionactivity::class.java)
            intent.putExtra("topic","2")
            startActivity(intent)
            finish()
        }
        anotheracc.setOnClickListener{
            var a=Intent(this,loginactivity::class.java)
            startActivity(a)
            finish()
        }
        gotoeditprofile.setOnClickListener {
            var b=Intent(this,editprofile::class.java)
            startActivity(b)
            finish()
        }

    }
}