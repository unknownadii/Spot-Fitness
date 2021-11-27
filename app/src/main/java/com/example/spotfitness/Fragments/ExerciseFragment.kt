package com.example.spotfitness.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotfitness.Data.AllExercisesClass
import com.example.spotfitness.Adapter.ExerciseAdapter
import com.example.spotfitness.R
import kotlinx.android.synthetic.main.fragment_exercise.*

class ExerciseFragment: Fragment(R.layout.fragment_exercise){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ll_menuBar.visibility=View.GONE
        // this creates a vertical layout Manager
        rv_ExerciseFragment.layoutManager = LinearLayoutManager(requireContext())

        val userData = AllExercisesClass.addExerciseData()
        // This will pass the ArrayList to our Adapter
        val adapter = ExerciseAdapter(userData)

        // Setting the Adapter with the recyclerview
        rv_ExerciseFragment.adapter = adapter
    }
}