package com.example.spotfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_doing_exercise.*
import kotlinx.android.synthetic.main.activity_exercise.*
import kotlinx.android.synthetic.main.activity_exercise.toolbar_exercise

class DoingExerciseActivity : AppCompatActivity() {
    private var restProgress = 0
    private var restTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doing_exercise)

        setSupportActionBar(findViewById(R.id.toolbar_Doing_exercise))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_Doing_exercise.setNavigationOnClickListener {
            onBackPressed()
        }
        setRestProgressBar()
    }
    private fun setRestProgressBar() {

        progressBarExercise.progress = restProgress
        // Sets the current progress to the specified value.
        // Here we have started a timer of 10 seconds so the 10000 is milliseconds is 10 seconds and the countdown interval is 1 second so it 1000.
        restTimer = object : CountDownTimer(10000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                // It is increased by 1
                progressBarExercise.progress = 10 - restProgress
                // Indicates progress bar progress
                tvTimer.text = (10 - restProgress).toString()
               // Current progress is set to text view in terms of seconds.
            }

            override fun onFinish() {
                //currentExercisePosition++

               // exerciseList!![currentExercisePosition].setIsSelected(true) // Current Item is selected
               // exerciseAdapter!!.notifyDataSetChanged() // Notified the current item to the adapter class to reflect it into UI.

               // setupExerciseView()
            }
        }.start()
    }
}