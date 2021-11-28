package com.example.spotfitness.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.spotfitness.Data.AllExercisesClass
import com.example.spotfitness.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_finish.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FinishActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var dialog: Dialog
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(findViewById(R.id.toolbar_Finish_exercise))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        auth = Firebase.auth
        setTime()
        toolbar_Finish_exercise.setNavigationOnClickListener {
            onBackPressed()
        }
        btn_Finish.setOnClickListener {
            finish()
        }
    }

    private fun setTime() {
        val df: DateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm")
        val currentTime: String = df.format(Calendar.getInstance().time)
        AllExercisesClass.arrayHistoryList.add(currentTime)
        addDateData(currentTime)
    }

    private fun addDateData(time: String) {

        val uiduser = auth.currentUser!!.uid

        database = FirebaseDatabase.getInstance(
            "https://spot-fitness-b9a62-default-rtdb.asia-southeast1.firebasedatabase.app/"
        )
            .getReference("users")
        database.child(uiduser).child("ExerciseHistory")
           .setValue(AllExercisesClass.arrayHistoryList).addOnCompleteListener {

            Toast.makeText(this, "successful added in Exercisehistory", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "failed to add Exercisehistory", Toast.LENGTH_SHORT).show()
        }
    }
}