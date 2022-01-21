package com.example.in_quiz_ition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_editprofile.*


class editprofile : AppCompatActivity() {

    val gender = arrayOf("Male", "Female","Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        var db : DocumentReference = FirebaseFirestore.getInstance().document("users/user_details")

        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gender)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpin!!.setAdapter (genderAdapter)

        save.setOnClickListener{

                val nicknametxt = findViewById<View>(R.id.nickname) as EditText
                val nametxt = findViewById<View>(R.id.name) as EditText
                val dobtxt = findViewById<View>(R.id.dob) as EditText
                val emailtxt = findViewById<View>(R.id.email) as EditText

                val nickname = nicknametxt.text.toString().trim()
                val gender = genderSpin.selectedItem.toString().trim()
                val name = nametxt.text.toString().trim()
                val dob = dobtxt.text.toString().trim()
                val email_id = emailtxt.text.toString().trim()

                if (nickname.isNotEmpty() && name.isNotEmpty() && dob.isNotEmpty() && email_id.isNotEmpty() && gender.isNotEmpty())
                    {   print("message")
                        val backup =HashMap<String,String>()
                        backup.put("Name",name)
                        backup.put("Nickname",nickname)
                        backup.put("DOB",dob)
                        backup.put("email",email_id)
                        backup.put("gender",gender)

                        db.collection("${email_id}").document("MyDetails").set(backup).addOnSuccessListener{
                        Toast.makeText(this, "Successfully uploaded to the database :)", Toast.LENGTH_LONG).show()
                        var intent = Intent(this,topicselectactivity::class.java)
                        startActivity(intent)
                        finish()
                        }.addOnFailureListener{
                            exception: java.lang.Exception ->Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                else {
                    Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
                }


            }
        selecttopic.setOnClickListener {
            var intent=Intent(this,topicselectactivity::class.java)
            startActivity(intent)
            finish()
        }

        }

    }

