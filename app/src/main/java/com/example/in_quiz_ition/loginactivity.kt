package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_loginactivity.*
import kotlinx.android.synthetic.main.activity_signupactivity.*

class loginactivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        loginbutton.setOnClickListener{
            if(loginemail.text.toString().isEmpty() && loginpassword.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter your email & password.", Toast.LENGTH_SHORT).show()

            }
            else{

                val email:String=loginemail.text.toString().trim{it<=' '}
                val password:String=loginpassword.text.toString().trim{it<=' '}

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener{task->

                        if(task.isSuccessful) {
                            val firebaseUser:FirebaseUser=task.result!!.user!!
                            var intent=Intent(this@loginactivity,playbuttonactivity::class.java)
                            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("user_id",firebaseUser.uid)
                            intent.putExtra("email_id",firebaseUser.email)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Toast.makeText(this@loginactivity,task.exception!!.message.toString() , Toast.LENGTH_SHORT).show()
                            intent= Intent(this@loginactivity,signupactivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }



            }
        }
        gotosignup.setOnClickListener{
            var intent=Intent(this@loginactivity,signupactivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}