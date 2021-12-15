package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if(input.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter your name.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var intent = Intent(this@MainActivity,questionactivity::class.java)
                intent.putExtra("${setdata.name}",input.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}*/

/*


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
*/
class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN


        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        /**If user is not authenticated, send him to loginactivity to authenticate first.
         * Else send him to topicselectactivity*/
        Handler().postDelayed({
            if(user != null){
                val intent = Intent(this, topicselectactivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, loginactivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)

    }
}