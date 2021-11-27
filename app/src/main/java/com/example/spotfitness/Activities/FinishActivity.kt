package com.example.spotfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spotfitness.R
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
        btn_Finish.setOnClickListener {
            finish()
        }
    }
}