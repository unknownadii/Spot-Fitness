package com.example.spotfitness

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.profile_dialog.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_menuBar.setOnClickListener {
            showDialog()
            Toast.makeText(this, "opening profile ", Toast.LENGTH_SHORT).show()
        }
        val homeFragment = HomeFragment()
        createFragment(homeFragment)
        //for the bottom navigation bar
        bottomNavigationView.background = null
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.home_icon ->{
                    Toast.makeText(this, "home selected", Toast.LENGTH_SHORT).show()
                }
                R.id.nutrition_icon ->{
                    Toast.makeText(this, "nutrition_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.exercises_icon ->{
                    Toast.makeText(this, "exercises_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.history_icon ->{
                    Toast.makeText(this, "history_icon selected", Toast.LENGTH_SHORT).show()
                }
                R.id.bmi_icon ->{
                    Toast.makeText(this, "bmi_icon selected", Toast.LENGTH_SHORT).show()
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
        val testingButton=dialog.findViewById<Button>(R.id.testingButton)

        testingButton.setOnClickListener {
            dialog.cancel()
        }
        dialog.show()

    }

    private fun createFragment(item: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_Fragment, item)
            commit()
        }
    }
}