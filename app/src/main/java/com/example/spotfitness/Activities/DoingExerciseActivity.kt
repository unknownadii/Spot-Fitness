package com.example.spotfitness.Activities

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.spotfitness.Data.AllExercisesClass
import com.example.spotfitness.Data.ExerciseData
import com.example.spotfitness.R
import kotlinx.android.synthetic.main.activity_doing_exercise.*
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*

class DoingExerciseActivity : AppCompatActivity() {
    private var restProgress = 0
    private var restTimer: CountDownTimer? = null
    private var count = 0
    private var exerciseCount = 0
    private lateinit var exerciselist: ArrayList<ExerciseData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doing_exercise)

        setSupportActionBar(findViewById(R.id.toolbar_Doing_exercise))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_Doing_exercise.setNavigationOnClickListener {
            customDialogForBackButton()
        }

        exerciselist = AllExercisesClass.addExerciseData()

        exerciseInvisibilty()

    }

    private fun setRestProgressBar() {

        restProgress = 0
        progressBarExercise.progress = restProgress
        // Sets the current progress to the specified value.
        // Here we have started a timer of 10 seconds so the 10000 is milliseconds is 10 seconds and the countdown interval is 1 second so it 1000.
        restTimer = object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                // It is increased by 1
                progressBarExercise.progress = 2 - restProgress
                // Indicates progress bar progress
                tvTimer.text = (2 - restProgress).toString()
                // Current progress is set to text view in terms of seconds.
            }

            override fun onFinish() {
                //currentExercisePosition++

                // exerciseList!![currentExercisePosition].setIsSelected(true)
                // Current Item is selected
                // exerciseAdapter!!.notifyDataSetChanged()
                // Notified the current item to the adapter class to reflect it into UI.
                if (count == 1) {
                    setupExerciseView()
                } else if (count == 0) {
                    exerciseInvisibilty()
                }
            }
        }.start()
    }

    private fun setupExerciseView() {
        if(exerciseCount<10) {

            setExercise(exerciseCount)
            getReadyInvisibilty()
            exerciseCount += 1
        }
    }

    private fun exerciseInvisibilty() {
         if (exerciseCount >= 10) {
            startActivity(Intent(this, FinishActivity::class.java))
            finish()
        }
        else{
             tv_upcomingExercise.text = exerciselist[exerciseCount].ExerciseName
         }


        iv_doingExercise.visibility = View.GONE
        tv_goingOnExercise.visibility = View.GONE
        btn_StopExercise.visibility = View.GONE

        tv_GetReadyFor.visibility = View.VISIBLE
        tv_upcomingExercise.visibility = View.VISIBLE
        count = 1
        setRestProgressBar()

    }

    private fun getReadyInvisibilty() {
        tv_GetReadyFor.visibility = View.GONE
        tv_upcomingExercise.visibility = View.GONE
        iv_doingExercise.visibility = View.VISIBLE
        tv_goingOnExercise.visibility = View.VISIBLE
        btn_StopExercise.visibility = View.VISIBLE
        count = 0
        setRestProgressBar()
    }

    private fun setExercise(count: Int) {
        val data = exerciselist[count]
        iv_doingExercise.setImageResource(data.ExerciseImage)
        tv_goingOnExercise.text = data.ExerciseName
    }
    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        /*Set the screen content from a layout resource.
         The resource will be inflated, adding all top-level views to the screen.*/
        customDialog.setContentView(R.layout.dialog_custom_back_confirmation)
        customDialog.tvYes.setOnClickListener {
            finish()
            customDialog.dismiss() // Dialog will be
        }
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }
}