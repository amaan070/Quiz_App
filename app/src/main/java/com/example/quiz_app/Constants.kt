package com.example.quiz_app

object Constants {

    const val USER_NAME : String = "username"
    const val TOTAL_QUESTIONS : String = "total questions"
    const val CORRECT_ANSWERS : String = "correct answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val ques1 = Question(
            1,
            "What is my favourite color?",
             R.drawable.colors,
            "Black","Indigo","A combination of blue and pink","Orange",
            3
        )
        questionsList.add(ques1)

        val ques2 = Question(
            2,
            "What is my favourite season?",
            R.drawable.season,
            "Summer","Winter","Spring","Monsoon",
            2
        )
        questionsList.add(ques2)

        val ques3 = Question(
            3,
            "I am sad, you can make me happy by making me food, what food would I love?",
            R.drawable.food,
            "Palak Paneer","Biryani","Burger","French Fries",
            1
        )
        questionsList.add(ques3)

        val ques4 = Question(
            4,
            "Which gym day is my favourite?",
            R.drawable.workout,
            "Leg day","Chest Day","Back Day","Shoulder Day",
            3
        )
        questionsList.add(ques4)

        val ques5 = Question(
            5,"Who is my favourite actor?",
            R.drawable.bale,
            "Christian Bale", "Hugh Jackman","Tom Cruise","Leonardo DiCaprio",
            1
        )
        questionsList.add(ques5)

        val ques6 = Question(
            6,"Who is my favourite youtuber",
            R.drawable.yt,
            "BB Ki Vines", "Niga-Higa","Tanmay Bhat","Mr. Beast",
            3
        )
        questionsList.add(ques6)

        val ques7 = Question(
            5,"What is my nickname?",
            R.drawable.nickname,
            "Mannu", "AMN","Beta","Chotu",
            1
        )
        questionsList.add(ques7)

        val ques8 = Question(
            8,"What is my favourite football club?",
            R.drawable.footballteam,
            "Bayern Munich", "FC Barcelona","Arsenal","Real Madrid",
            2
        )
        questionsList.add(ques8)

        val ques9 = Question(
            9,"What is my favourite Movie?",
            R.drawable.mvie,
            "Interstellar", "Inception","Fight Club","John Wick",
            1
        )
        questionsList.add(ques9)

        val ques10 = Question(
            10,"Who is my favourite rapper?",
            R.drawable.rapper,
            "Drake", "Eminem","Snoop Dogg","Lil Wayne",
            2
        )
        questionsList.add(ques10)

        val ques11 = Question(
            11,"What is my favourite drink?",
            R.drawable.deink,
            "Cold Coffee", "Cold Drink","Orange Juice","Hot Chocolate",
            4
        )
        questionsList.add(ques11)

        val ques12 = Question(
            12,
            "What is my favourite holiday destination?",
            R.drawable.msterdam,
            "Amsterdam","Norway","France","Spain",
            2
        )
        questionsList.add(ques12)

        val ques13 = Question(
            13,
            "Who is my favourite WWE Legend?",
            R.drawable.wwe,
            "Rey Mysterio","Big Show","        ","Brok Lesnar",
            3
        )
        questionsList.add(ques13)

        val ques14 = Question(
            14,
            "Who is my favourite comedian?",
            R.drawable.comedian,
            "Abhishek Upmanyu","Munawwar","Zakir","Akash",
            1
        )
        questionsList.add(ques14)

        val ques15 = Question(
            15,
            "Who is my favourite hindi singer?",
            R.drawable.sing,
            "Atif Aslam","KK","Arijit","Armaan Malik",
            2
        )
        questionsList.add(ques15)


        return questionsList
    }
}