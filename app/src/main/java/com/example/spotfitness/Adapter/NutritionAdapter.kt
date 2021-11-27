package com.example.spotfitness.Adapter

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spotfitness.Data.ExerciseData
import com.example.spotfitness.Data.NutritionData
import com.example.spotfitness.R

class NutritionAdapter : RecyclerView.Adapter<NutritionAdapter.ViewHolder>() {

    private var nutritionList: ArrayList<NutritionData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_nutrition, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val exerciseData = nutritionList[position]

        holder.nutritionName.text = exerciseData.nutritionName
        holder.nutritionAmount.text = exerciseData.nutritionAmount

    }

    override fun getItemCount(): Int {
        return nutritionList.size
    }
    fun update(updatedItems: ArrayList<NutritionData>) {
        nutritionList.clear()
        nutritionList.addAll(updatedItems)
        notifyDataSetChanged()
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val nutritionName: TextView = itemView.findViewById(R.id.tv_Nutrition_name)
        val nutritionAmount: TextView = itemView.findViewById(R.id.tv_Nutrition_amount)
    }

}
