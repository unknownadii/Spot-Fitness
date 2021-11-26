package com.example.spotfitness

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.spotfitness.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_menuBar.setOnClickListener {
            showDialog()

        }
        val homeFragment = HomeFragment()
        createFragment(homeFragment)
        //for the bottom navigation bar
        bottomNavigationView.background = null
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_icon -> {
                    val homeFragment = HomeFragment()
                    createFragment(homeFragment)
                }
                R.id.nutrition_icon -> {
                    val nutritionFragment = NutritionFragment()
                    createFragment(nutritionFragment)

                }
                R.id.exercises_icon -> {
                    val exerciseFragment = ExerciseFragment()
                    createFragment(exerciseFragment)
                }
                R.id.history_icon -> {
                    val historyFragment = HistoryFragment()
                    createFragment(historyFragment)
                }
                R.id.bmi_icon -> {
                    val bmiFragment = BmiFragment()
                    createFragment(bmiFragment)
                }
            }
            true
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.profile_dialog)
        val profileClose = dialog.findViewById<ImageView>(R.id.profileClose)
        val logout = dialog.findViewById<ImageView>(R.id.logout_btn)
        val editBtnProfile = dialog.findViewById<Button>(R.id.edit_btnProfile)
        val submitBtnProfile = dialog.findViewById<Button>(R.id.submit_btnProfile)
        val lvSavedProfile = dialog.findViewById<LinearLayout>(R.id.lv_savedProfileData)
        val lvEditProfile = dialog.findViewById<LinearLayout>(R.id.lv_editProfileData)

        profileClose.setOnClickListener {
            dialog.dismiss()
        }

        editBtnProfile.setOnClickListener {
            lvSavedProfile.visibility=View.GONE
            lvEditProfile.visibility=View.VISIBLE
        }
        submitBtnProfile.setOnClickListener {
            lvSavedProfile.visibility=View.VISIBLE
            lvEditProfile.visibility=View.GONE
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
        logout.setOnClickListener {
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //animation
        //dialog.window!!.getAttributes().windowAnimations = R.style.CustomDialogAnimation;
        dialog.show()
    }

    private fun createFragment(item: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_Fragment, item)
            commit()
        }
    }
}