package com.example.spotfitness

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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

        holder.exerciseBlock.setOnClickListener {
            val dialog = Dialog(it.context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.bottom_popup)
            val backArrow = dialog.findViewById<ImageView>(R.id.backArrowPopup)

            val dishname = dialog.findViewById<TextView>(R.id.popupDishName)
            val dishimage = dialog.findViewById<ImageView>(R.id.popupDishImage)
            val dishdescription = dialog.findViewById<TextView>(R.id.popUpDishDescription)

            dishname.text = exerciseData.ExerciseName
            dishdescription.text = exerciseData.ExerciseDescription

            //getting image of popup
            Glide.with(it.context)
                .load(exerciseData.ExerciseImage)
                .into(dishimage)

            backArrow.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show();
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog.window!!.getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.window!!.setGravity(Gravity.BOTTOM);
        }

    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val exerciseImage: ImageView = itemView.findViewById(R.id.iv_iconExercise)
        val exerciseName: TextView = itemView.findViewById(R.id.tv_ExerciseName)
        val exerciseTime: TextView = itemView.findViewById(R.id.tv_ExerciseTime)
        val exerciseBlock: CardView = itemView.findViewById(R.id.cv_exerciseList)
    }

}