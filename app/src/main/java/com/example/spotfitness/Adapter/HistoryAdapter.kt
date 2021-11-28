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
import com.example.spotfitness.Data.HistoryData
import com.example.spotfitness.Data.NutritionData
import com.example.spotfitness.R

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var historyList: ArrayList<HistoryData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_history_content, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val historyData = historyList[position]

        holder.historyName.text = historyData.historyName

    }

    override fun getItemCount(): Int {
        return historyList.size
    }
    fun update(updatedItems: ArrayList<HistoryData>) {
        historyList.clear()
        historyList.addAll(updatedItems)
        notifyDataSetChanged()
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val historyName: TextView = itemView.findViewById(R.id.tv_History_name)

    }

}
