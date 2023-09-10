package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart:Button= findViewById(R.id.startButton)
        val name:EditText=findViewById(R.id.nameEnter)
        btnStart.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent=Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME, name.text.toString() )
                startActivity(intent)
            }
        }
    }
}