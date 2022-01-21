package com.example.in_quiz_ition

object setdata2 {

    fun getqeustion():ArrayList<questiondata>
    {
        var que:ArrayList<questiondata> = arrayListOf()
        var q1=questiondata(

            "How many sisters does Joey have?",
            1,
            "7",
            "6",
            "10",
            "5",
            1
        )
        var q2=questiondata(

            "Where did Carol first meet Susan?",
            1,
            "At a bar",
            "At work",
            "At the park",
            "At the gym",
            4
        )
        var q3=questiondata(

            "How long did Ross and Emily date before they got engaged?",
            1,
            "14 days",
            "6 weeks",
            "A year",
            "3 months",
            2
        )
        var q4=questiondata(

            "What was Joey's favorite sandwich?",
            1,
            "Salami",
            "PB&J",
            "Ham n Cheese",
            "Meatball Sub",
            4
        )
        var q5=questiondata(

            "Who did Rachel discover her ex-fiancé Barry was cheating on her with?",
            1,
            "Her sister",
            "Her Sister",
            "Her Best Friend",
            "His School Friend",
            3

        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que

    }
}