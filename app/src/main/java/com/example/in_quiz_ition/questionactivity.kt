package com.example.in_quiz_ition

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questionactivity.*

class questionactivity : AppCompatActivity() {

    private var score:Int=0
    private var currentposition: Int=1
    private var questionList : ArrayList<questiondata>?=null
    private var selectedoption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)
        var counter=intent.getStringExtra("topic")

            if (counter=="1")
            {
                questionList=setdata.getqeustion()

            }
        else
            {
                questionList=setdata2.getqeustion()
            }

        setquestion()
        submit.text="Submit"


        op1.setOnClickListener{
           selectedoptionstyle(op1,1)
        }
        op2.setOnClickListener{
            selectedoptionstyle(op2,2)
        }
        op3.setOnClickListener{
            selectedoptionstyle(op3,3)
        }
        op4.setOnClickListener{
            selectedoptionstyle(op4,4)
        }

        submit.setOnClickListener{
            op1.isEnabled=false
            op2.isEnabled=false
            op3.isEnabled=false
            op4.isEnabled=false
            if (selectedoption!=0)
            {
                val question=questionList!![currentposition-1]
                if (selectedoption!=question.correctans)
                {
                    setcolor(selectedoption,R.drawable.incorrectselectedoptionbackground)
                    if(currentposition==questionList!!.size)
                    {
                        submit.text="FINISH"
                    }
                    else
                    {
                        submit.text="Next Question"
                    }
                }
                else{
                    setcolor(question.correctans,R.drawable.correctselectedoptionbackground)
                    score++
                    if(currentposition==questionList!!.size)
                    {
                        submit.text="Finish"
                    }
                    else
                    {
                        submit.text="Next Question"
                    }

                }
                setcolor(question.correctans,R.drawable.correctselectedoptionbackground)

            }
            else
            {
                currentposition++
                when{
                    currentposition<=questionList!!.size->
                    {
                        setquestion()
                        submit.text="Submit"
                    }
                    else->{

                        var intent=Intent(this@questionactivity,result::class.java)
                        intent.putExtra("score",score)
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedoption=0


        }


    }

    fun setcolor(opt: Int,color:Int)
    {
         when(opt)
         {
             1->{
                 op1.background=ContextCompat.getDrawable(this,color)
             }
             2->{
                 op2.background=ContextCompat.getDrawable(this,color)
             }
             3->{
                 op3.background=ContextCompat.getDrawable(this,color)
             }
             4->{
                 op4.background=ContextCompat.getDrawable(this,color)
             }

         }
    }
    fun setquestion()
    {
        val question = questionList!![currentposition-1]
        setoptionstyle()

        progressbar.progress=currentposition
        progressbar.max=questionList!!.size
        progresstext.text= "${currentposition} / ${questionList!!.size}"
        ques.text=question.question
        op1.text=question.option1
        op2.text=question.option2
        op3.text=question.option3
        op4.text=question.option4
        op1.isEnabled=true
        op2.isEnabled=true
        op3.isEnabled=true
        op4.isEnabled=true

    }
    fun setoptionstyle()
    {
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,op1)
        optionList.add(1,op2)
        optionList.add(2,op3)
        optionList.add(3,op4)

        for (op in optionList)
        {
            op.background=ContextCompat.getDrawable(this,R.drawable.border2)
            op.typeface= Typeface.DEFAULT
        }
    }
    fun selectedoptionstyle(view: TextView,opt: Int)
    {
        setoptionstyle()
        selectedoption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selectedoptionbackground)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#FFB4F8C8"))
    }
}