package com.example.spotfitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(findViewById(R.id.toolbar_exercise))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_exercise.setNavigationOnClickListener {
            onBackPressed()
        }
        // this creates a vertical layout Manager
        rv_ExerciseActivity.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ExerciseData>()
        addExerciseData(data)
        // This will pass the ArrayList to our Adapter
        val adapter = ExerciseAdapter(data)

        // Setting the Adapter with the recyclerview
       rv_ExerciseActivity.adapter = adapter
        btn_startExercise.setOnClickListener {
            startActivity(Intent(this,DoingExerciseActivity::class.java))
            finish()
        }

    }

    private fun addExerciseData(listData :ArrayList<ExerciseData>)
    {
        listData.add(
            ExerciseData(R.drawable.star_jump,
            "Star Jump","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.squates,
                "Squats","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.pushups,
                "Push Ups","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.lungs,
                "Lunges","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.plank,
                "Plank","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.sideplank,
                "Side Plank","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.stepups,
                "Step-ups","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.chairdips,
                "Chair dips","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.wallsit,
                "Wall sit","10 Second")
        )
        listData.add(
            ExerciseData(R.drawable.pullups,
                "Pull-ups","10 Second")
        )
    }
}