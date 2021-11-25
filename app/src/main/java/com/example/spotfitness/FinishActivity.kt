package com.example.spotfitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_doing_exercise.*
import kotlinx.android.synthetic.main.activity_doing_exercise.toolbar_Doing_exercise
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(findViewById(R.id.toolbar_Finish_exercise))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar_Finish_exercise.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}