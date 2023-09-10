package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    private var progressbar : ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var image:ImageView?=null
    private var submitButton : Button? = null
    private var tvOptionOne : TextView?= null
    private var tvOptionTwo : TextView?= null
    private var tvOptionThree : TextView?= null
    private var tvOptionFour : TextView?= null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionList = Constants.getQuestions()

        progressbar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.progressNum)
        tvQuestion=findViewById(R.id.questionView)
        image=findViewById(R.id.imageView)
        submitButton=findViewById(R.id.submitBtn)
        tvOptionOne=findViewById(R.id.optionOne)
        tvOptionTwo=findViewById(R.id.optionTwo)
        tvOptionThree=findViewById(R.id.optionThree)
        tvOptionFour=findViewById(R.id.optionFour)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)

        setQuestion()
        defaultOptionsView()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        defaultOptionsView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]

        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressbar?.max}"
        tvQuestion?.text = question.question
        image?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition==mQuestionList!!.size){
            submitButton?.text="FINISH"
        }
        else{
            submitButton?.text="SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for ( i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne ->{
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }

            R.id.optionTwo ->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }

            R.id.optionThree ->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }

            R.id.optionFour ->{
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.submitBtn ->{
                if(mSelectedOptionPosition==0) {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        showAnswer(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }
                    showAnswer(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionList!!.size){
                        submitButton?.text="FINISH"
                    }
                    else submitButton?.text="GO TO NEXT QUESTION"

                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun showAnswer(answer:Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOptionOne?.background= ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOptionTwo?.background= ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOptionThree?.background= ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOptionFour?.background= ContextCompat.getDrawable(this,drawableView)
                }
        }
    }
}