package com.example.in_quiz_ition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questionactivity.*

class questionactivity : AppCompatActivity() {
    private var questionList : ArrayList<questiondata>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)
        setdata.getqeustion()


        questionList=setdata.getqeustion()
        var que=questionList!![0]
        question.text=que.question
        op1.setOnClickListener{
            op1.background=ContextCompat.getDrawable(this,R.drawable.selectedoptionbackground)
        }
        op2.setOnClickListener{
            op2.background=ContextCompat.getDrawable(this,R.drawable.selectedoptionbackground)
        }
        op3.setOnClickListener{
            op3.background=ContextCompat.getDrawable(this,R.drawable.selectedoptionbackground)
        }
        op4.setOnClickListener{
            op4.background=ContextCompat.getDrawable(this,R.drawable.selectedoptionbackground)
        }
        op1.text=que.option1
        op2.text=que.option2
        op3.text=que.option3
        op4.text=que.option4
        progressbar.progress=que.progress
        progresstext.text=que.progresstxt
    }
}