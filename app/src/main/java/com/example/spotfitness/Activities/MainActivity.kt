package com.example.spotfitness.Activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.spotfitness.Fragments.*
import com.example.spotfitness.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.profile_dialog.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    lateinit var dialog: Dialog

    lateinit var dialogUserName: String
    lateinit var dialogUserEditName: String
    lateinit var dialogUserEmail: String
    lateinit var dialogUserAge: String
    lateinit var dialogUserEditAge: String
    lateinit var dialogUserGender: String
    lateinit var dialogUserEditGender: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        writeData()



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
                    ll_menuBar.visibility = View.VISIBLE
                    val homeFragment = HomeFragment()
                    createFragment(homeFragment)
                }
                R.id.nutrition_icon -> {
                    ll_menuBar.visibility = View.GONE
                    val nutritionFragment = NutritionFragment()
                    createFragment(nutritionFragment)

                }
                R.id.exercises_icon -> {
                    ll_menuBar.visibility = View.GONE
                    val exerciseFragment = ExerciseFragment()
                    createFragment(exerciseFragment)
                }
                R.id.history_icon -> {
                    ll_menuBar.visibility = View.GONE
                    val historyFragment = HistoryFragment()
                    createFragment(historyFragment)
                }
                R.id.bmi_icon -> {
                    ll_menuBar.visibility = View.GONE
                    val bmiFragment = BmiFragment()
                    createFragment(bmiFragment)
                }
            }
            true
        }
    }


    private fun showDialog() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.profile_dialog)
        val profileClose = dialog.findViewById<ImageView>(R.id.profileClose)
        val logout = dialog.findViewById<LinearLayout>(R.id.ll_Logout)
        val editBtnProfile = dialog.findViewById<Button>(R.id.edit_btnProfile)
        val submitBtnProfile = dialog.findViewById<Button>(R.id.submit_btnProfile)
        val lvSavedProfile = dialog.findViewById<LinearLayout>(R.id.lv_savedProfileData)
        val lvEditProfile = dialog.findViewById<LinearLayout>(R.id.lv_editProfileData)


        var userName = dialog.findViewById<TextView>(R.id.tv_userNameDisplay)
        var userEmail = dialog.findViewById<TextView>(R.id.tv_userEmailDisplay)
        var userAge = dialog.findViewById<TextView>(R.id.tv_userDisplayAge)
        var userGender = dialog.findViewById<TextView>(R.id.tv_userDisplayGender)


        //firebase write call
        userName.text = dialogUserName
        userEmail.text = dialogUserEmail
        userAge.text = dialogUserAge
        userGender.text = dialogUserGender


        profileClose.setOnClickListener {
            dialog.dismiss()
        }

        editBtnProfile.setOnClickListener {
            lvSavedProfile.visibility = View.GONE
            lvEditProfile.visibility = View.VISIBLE
        }
        submitBtnProfile.setOnClickListener {
            var userEditName = dialog.findViewById<EditText>(R.id.et_dialogEditName)
            var userEditAge = dialog.findViewById<TextView>(R.id.et_dialogEditAge)
            var userEditGender = dialog.findViewById<TextView>(R.id.et_dialogEditGender)
            if (!userEditName.text.isEmpty() && !userEditAge.text.isEmpty() && !userEditGender.text.isEmpty()) {

                dialogUserEditName = userEditName.text.toString()
                dialogUserEditAge = userEditAge.text.toString()
                dialogUserEditGender = userEditGender.text.toString()
                updateData()
                lvSavedProfile.visibility = View.VISIBLE
                lvEditProfile.visibility = View.GONE
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                startActivity(Intent(this,MainActivity::class.java))
                //it is used for clearing the stack before that
                finishAffinity()
            } else {
                Toast.makeText(this, "enter something to continue", Toast.LENGTH_SHORT).show()
            }
        }
        logout.setOnClickListener {
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show()
            Firebase.auth.signOut()
            startActivity(Intent(this, RegisterAndLoginActivity::class.java))
            dialog.dismiss()
            finish()
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

    private fun writeData() {
        //firebase write call
        val uiduser = auth.currentUser!!.uid
        database = FirebaseDatabase.getInstance(
            "https://spot-fitness-b9a62-default-rtdb.asia-southeast1.firebasedatabase.app/"
        ).getReference("users")
        database.child(uiduser).get().addOnCompleteListener {
            try {
                if (it.isSuccessful) {
                    val dataSnapshot: DataSnapshot? = it.result
                    val name = dataSnapshot!!.child("userName").value
                    val email = dataSnapshot!!.child("userEmail").value
                    val age = dataSnapshot!!.child("userAge").value
                    val gender = dataSnapshot!!.child("userGender").value
                    dialogUserName = name.toString()

                    tv_HomeFragmentUserName.text= name.toString()

                    dialogUserEmail = email.toString()
                    dialogUserAge = age.toString()
                    dialogUserGender = gender.toString()
                    //      Toast.makeText(this, "succesfully read", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Error in loading Data pf Profile", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show()
            }

        }
    }


    private fun updateData() {
        database = FirebaseDatabase.getInstance(
            "https://spot-fitness-b9a62-default-rtdb.asia-southeast1.firebasedatabase.app/"
        ).getReference("users")
        val uiduser = auth.currentUser!!.uid
        val user = mapOf<String, String>(
            "userName" to dialogUserEditName,
            "userAge" to dialogUserEditAge,
            "userGender" to dialogUserEditGender
        )
        database.child(uiduser).updateChildren(user).addOnCompleteListener {
            Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show()
            dialogUserName=dialogUserEditName
            dialogUserAge =dialogUserEditAge
            dialogUserGender = dialogUserEditGender
            writeData()

        }.addOnFailureListener {
            Toast.makeText(this, "failed to update", Toast.LENGTH_SHORT).show()
        }
    }
}