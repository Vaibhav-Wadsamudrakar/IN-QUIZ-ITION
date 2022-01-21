package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_editprofile.*
import kotlinx.android.synthetic.main.activity_loginactivity.*
import kotlinx.android.synthetic.main.activity_signupactivity.*
import kotlinx.android.synthetic.main.activity_signupactivity.dob
import kotlinx.android.synthetic.main.activity_signupactivity.genderSpin
import kotlinx.android.synthetic.main.activity_signupactivity.name
import kotlinx.android.synthetic.main.activity_signupactivity.nickname

class signupactivity : AppCompatActivity() {

    val gender = arrayOf("Male", "Female","Do not wish to disclose")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupactivity)

        var db : DocumentReference = FirebaseFirestore.getInstance().document("users/user_details")

        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gender)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpin!!.setAdapter (genderAdapter)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        signupbutton.setOnClickListener{
            if(signupemail.text.toString().isEmpty() && signuppassword.text.toString().isEmpty() && nickname.text.toString().isEmpty() && name.text.toString().isEmpty() && dob.text.toString().isEmpty() && email.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter your email & password.", Toast.LENGTH_SHORT).show()

            }
            else{

                val nicknametxt = findViewById<View>(R.id.nickname) as EditText
                val nametxt = findViewById<View>(R.id.name) as EditText
                val dobtxt = findViewById<View>(R.id.dob) as EditText
                val emailtxt = findViewById<View>(R.id.signupemail) as EditText
                val passwordtxt = findViewById<View>(R.id.signuppassword) as EditText

                val nickname = nicknametxt.text.toString().trim()
                val gender = genderSpin.selectedItem.toString().trim()
                val name = nametxt.text.toString().trim()
                val dob = dobtxt.text.toString().trim()
                val email_id = emailtxt.text.toString().trim()
                val password_id = passwordtxt.text.toString().trim()

                if (nickname.isNotEmpty() && name.isNotEmpty() && dob.isNotEmpty() && email_id.isNotEmpty() && gender.isNotEmpty())
                {   print("message")
                    val backup =HashMap<String,String>()
                    backup.put("Name",name)
                    backup.put("Nickname",nickname)
                    backup.put("DOB",dob)
                    backup.put("email",email_id)
                    backup.put("gender",gender)
                    backup.put("password",password_id)

                    db.collection("${email_id}").document("MyDetails").set(backup).addOnSuccessListener{
                        Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
//                        var intent = Intent(this,loginactivity::class.java)
//                        startActivity(intent)
//                        finish()
                    }.addOnFailureListener{
                            exception: java.lang.Exception ->Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
                else {
                    Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
                }

                val email:String=signupemail.text.toString().trim{it<=' '}
                val password:String=signuppassword.text.toString().trim{it<=' '}

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{task->

                        if(task.isSuccessful) {
                            val firebaseUser:FirebaseUser=task.result!!.user!!
                            Toast.makeText(this, "You are registered successfully!", Toast.LENGTH_SHORT).show()
                            var intent=Intent(this@signupactivity,topicselectactivity::class.java)
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