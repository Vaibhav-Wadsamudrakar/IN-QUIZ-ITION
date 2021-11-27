package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_loginactivity.*
import kotlinx.android.synthetic.main.activity_signupactivity.*

class signupactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupactivity)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        signupbutton.setOnClickListener{
            if(signupemail.text.toString().isEmpty() && signuppassword.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter your email & password.", Toast.LENGTH_SHORT).show()

            }
            else{

                val email:String=signupemail.text.toString().trim{it<=' '}
                val password:String=signuppassword.text.toString().trim{it<=' '}

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{task->

                        if(task.isSuccessful) {
                            val firebaseUser:FirebaseUser=task.result!!.user!!
                            Toast.makeText(this, "You are registered successfully!", Toast.LENGTH_SHORT).show()
                            var intent=Intent(this@signupactivity,MainActivity::class.java)
                            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("user_id",firebaseUser.uid)
                            intent.putExtra("email_id",firebaseUser.email)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Toast.makeText(this@signupactivity,task.exception!!.message.toString() , Toast.LENGTH_SHORT).show()
                        }

                    }



            }
        }
        gotologin.setOnClickListener{
            var intent=Intent(this@signupactivity,loginactivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}