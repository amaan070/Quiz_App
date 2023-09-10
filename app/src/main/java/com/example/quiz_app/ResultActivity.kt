package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val displayName : TextView = findViewById(R.id.username)
        val displayScore : TextView = findViewById(R.id.scoreView)
        val finishButton : Button =  findViewById(R.id.finalBtn)

        displayName.text=intent.getStringExtra(Constants.USER_NAME)
        displayScore.text = "Your score is: ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)} / ${intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)} "
        finishButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}