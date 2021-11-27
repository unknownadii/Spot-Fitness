package com.example.spotfitness.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotfitness.Data.AllExercisesClass
import com.example.spotfitness.Adapter.ExerciseAdapter
import com.example.spotfitness.R
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

        val userData = AllExercisesClass.addExerciseData()
        // This will pass the ArrayList to our Adapter
        val adapter = ExerciseAdapter(userData)

        // Setting the Adapter with the recyclerview
       rv_ExerciseActivity.adapter = adapter
        btn_startExercise.setOnClickListener {
            startActivity(Intent(this, DoingExerciseActivity::class.java))
            finish()
        }

    }

}