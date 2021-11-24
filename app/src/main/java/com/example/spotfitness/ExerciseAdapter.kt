package com.example.spotfitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter (private val exerciseList: List<ExerciseData>) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_exercise_activity, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val exerciseData = exerciseList[position]

        holder.exerciseImage.setImageResource(exerciseData.ExerciseImage)

        holder.exerciseName.text = exerciseData.ExerciseName
        holder.exerciseTime.text = exerciseData.ExerciseTime

    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val exerciseImage: ImageView = itemView.findViewById(R.id.iv_iconExercise)
        val exerciseName: TextView = itemView.findViewById(R.id.tv_ExerciseName)
        val exerciseTime: TextView = itemView.findViewById(R.id.tv_ExerciseTime)
    }
}