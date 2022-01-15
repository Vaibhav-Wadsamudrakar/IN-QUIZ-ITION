package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_editprofile.*


class editprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        var db : DocumentReference = FirebaseFirestore.getInstance().document("users/user details")
        save.setOnClickListener{

                val nicknametxt = findViewById<View>(R.id.nickname)
                val nametxt = findViewById<View>(R.id.name)
                val dobtxt = findViewById<View>(R.id.dob)
                val emailtxt = findViewById<View>(R.id.email)

                val nickname = nicknametxt.toString().trim()
                val name = nametxt.toString().trim()
                val dob = dobtxt.toString().trim()
                val email = emailtxt.toString().trim()

                if (nickname.isNotEmpty() && name.isNotEmpty() && dob.isNotEmpty() && email.isNotEmpty())
                    {
                        val backup =HashMap<String,Any>()
                        backup.put("Name",name)
                        backup.put("Nickname",nickname)
                        backup.put("DOB",dob)
                        backup.put("email",email)

                        db.collection(name).document("user details").set(backup).addOnSuccessListener{
                        Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
                        var b = Intent(this,topicselectactivity::class.java)
                        startActivity(b)
                        finish()
                        }.addOnFailureListener{
                            exception: java.lang.Exception ->Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                else {
                    Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
                }


            }

        }

    }

