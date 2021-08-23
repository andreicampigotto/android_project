package com.proway.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseUser
import com.proway.firebaseapplication.repository.AuthenticationRepository
import com.proway.firebaseapplication.view_model.LoginViewModel

class LoginActivity : AppCompatActivity() {

    //private val authenticationRepository = AuthenticationRepository()

    private lateinit var viewModel: LoginViewModel

    private val observerUser = Observer<FirebaseUser>{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            val inputEmail = findViewById<TextInputLayout>(R.id.textInputLogin)
            val inputPassword = findViewById<TextInputLayout>(R.id.textInputPassword)

            if (!inputEmail.editText?.text.isNullOrEmpty()
                || !inputPassword.editText?.text.isNullOrEmpty()
            ) {
                viewModel.user.observe(viewLifecycle, observerUser)
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        findViewById<View>(R.id.newAccountTextView).setOnClickListener {
            it
        }
    }
}