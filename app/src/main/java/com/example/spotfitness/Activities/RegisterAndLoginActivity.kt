package com.example.spotfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.spotfitness.R
import kotlinx.android.synthetic.main.activity_register_and_login.*

class RegisterAndLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_and_login)

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
    }
}