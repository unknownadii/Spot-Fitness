package com.example.spotfitness.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotfitness.Adapter.HistoryAdapter
import com.example.spotfitness.Adapter.NutritionAdapter
import com.example.spotfitness.Data.AllExercisesClass
import com.example.spotfitness.Data.HistoryData
import com.example.spotfitness.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_nutrition.*

class HistoryFragment : Fragment(R.layout.fragment_history) {

    lateinit var adapter: HistoryAdapter
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private var historyArrayList: ArrayList<HistoryData> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        rv_history.layoutManager = LinearLayoutManager(requireContext())
        adapter = HistoryAdapter()
        rv_history.adapter = adapter
        writeData()


    }

    private fun writeData() {
        val uiduser = auth.currentUser!!.uid
        database = FirebaseDatabase.getInstance(
            "https://spot-fitness-b9a62-default-rtdb.asia-southeast1.firebasedatabase.app/"
        ).getReference("users")
        database.child(uiduser).child("ExerciseHistory").get().addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(requireContext(), "succesfully read", Toast.LENGTH_SHORT).show()
                val dataSnapshot: DataSnapshot? = it.result

                val historyData = dataSnapshot!!.childrenCount
                if ( !AllExercisesClass.arrayHistoryList.isNullOrEmpty())
                {
                    AllExercisesClass.arrayHistoryList.clear()
                }
                for (i in 0 until historyData) {

                    val data = dataSnapshot!!.child(i.toString()).value

                    if (data != null) {
                        AllExercisesClass.arrayHistoryList.add(data.toString())
                        historyArrayList.add(HistoryData(data.toString()))
                    }
                }

                adapter.update(historyArrayList)
            }
        }
    }
}