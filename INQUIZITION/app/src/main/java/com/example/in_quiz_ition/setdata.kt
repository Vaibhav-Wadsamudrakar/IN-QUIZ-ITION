package com.example.in_quiz_ition

object setdata {

    fun getqeustion():ArrayList<questiondata>
    {
        var que:ArrayList<questiondata> = arrayListOf()
        var q1=questiondata(

            "What is the capital of India?",
            1,
            "Mumbai",
            "Delhi",
            "Lucknow",
            "Gujrat",
            2,
            1,
        "1/5"
        )
        var q2=questiondata(

            "What is the capital of USA?",
            1,
            "New York",
            "Los Angeles",
            "Miami",
            "Washington D.C.",
            2,
            2,
        "2/5"
        )
        var q3=questiondata(

            "What is the capital of Spain?",
            1,
            "Mumbai",
            "Delhi",
            "Lucknow",
            "Gujrat",
            2,
            3,
        "3/5"
        )
        var q4=questiondata(

            "What is the capital of India?",
            1,
            "Mumbai",
            "Delhi",
            "Lucknow",
            "Gujrat",
            2,
            4,
        "4/5"
        )
        var q5=questiondata(

            "What is the capital of India?",
            1,
            "Mumbai",
            "Delhi",
            "Lucknow",
            "Gujrat",
            2,
            5,
        "5/5"
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que

    }
}