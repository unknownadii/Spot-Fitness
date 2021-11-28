package com.example.spotfitness.Activities

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.spotfitness.Data.FirebaseUserData
import com.example.spotfitness.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_and_login.*

class RegisterAndLoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var dialog: Dialog
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_and_login)

        auth = Firebase.auth
        tv_Register.setOnClickListener {
            fl_Login.visibility= View.GONE
            btn_Login.visibility= View.GONE
            ll_Login.visibility= View.GONE

            fl_Register.visibility= View.VISIBLE
            btn_Register.visibility= View.VISIBLE
            ll_Register.visibility= View.VISIBLE
        }
        tv_Login.setOnClickListener {
            fl_Login.visibility= View.VISIBLE
            btn_Login.visibility= View.VISIBLE
            ll_Login.visibility= View.VISIBLE

            fl_Register.visibility= View.GONE
            btn_Register.visibility= View.GONE
            ll_Register.visibility= View.GONE
        }
        btn_Register.setOnClickListener {
            showDialog()
            registerUser()
        }
        btn_Login.setOnClickListener {
            showDialog()
            logInUser()
        }
    }

    private fun logInUser() {
        val email = email_Login.text.toString().trim { it <= ' ' }
        val password = password_Login.text.toString().trim { it <= ' ' }
        if (!email.isEmpty() && !password.isEmpty()) {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        hideDialog()
                        startActivity(Intent(this, MainActivity::class.java))
                        Toast.makeText(this, "Loging in", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        hideDialog()
                        Toast.makeText(this, "Log In failed", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            hideDialog()
            Toast.makeText(this, "please Write Something", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)

    }
    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            // User is signed in
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    private fun registerUser() {
        val email = email_Register.text.toString().trim { it <= ' ' }
        val password = password_Register.text.toString().trim { it <= ' ' }
        val name = name_Register.text.toString().trim { it <= ' ' }
        val age = age_Register.text.toString().trim { it <= ' ' }
        val gender = gender_Register.text.toString().trim { it <= ' ' }
        if (!email.isEmpty() && !password.isEmpty()
            && !name.isEmpty() && !age.isEmpty() && !gender.isEmpty()
        ) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        //adding data to realtime database
                        addData()
                        hideDialog()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()

                    } else {
                        hideDialog()
                        Toast.makeText(this, "register error", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun addData() {
        val email = email_Register.text.toString().trim { it <= ' ' }
        val name = name_Register.text.toString().trim { it <= ' ' }
        val age = age_Register.text.toString().trim { it <= ' ' }
        val gender = gender_Register.text.toString().trim { it <= ' ' }
        val user = FirebaseUserData(email,name,age,gender)
        val uiduser = auth.currentUser!!.uid
        database= FirebaseDatabase.getInstance("https://spot-fitness-b9a62-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users")
        database.child(uiduser).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            hideDialog()
            Toast.makeText(this, "failed adding data", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showDialog() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun hideDialog() {
        dialog.dismiss()
    }
}