package com.example.spotfitness.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.spotfitness.Activities.ExerciseActivity
import com.example.spotfitness.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // ll_menuBar.visibility=View.VISIBLE
        cardViewListner()
    }

    private fun cardViewListner()
    {
        cv_level1.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_level2.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_level3.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_level4.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_age16.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_age20.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_age25.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }
        cv_age30.setOnClickListener {
            startActivity(Intent(requireContext(), ExerciseActivity::class.java))
        }

    }

}