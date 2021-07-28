package com.proway.example.designer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.proway.example.designer.R
import com.proway.example.designer.classes.Formulario

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.saveButton).apply {
            setOnClickListener {

                checkFields(it)

                //Snackbar.make(it, "Click Ok", Snackbar.LENGTH_LONG).show()
                //Toast.makeText(context, "Click Ok", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkFields(view: View) {
        val form = Formulario()

        findViewById<EditText>(R.id.NameEditText).apply {
            form.name = text.toString()
        }

        findViewById<EditText>(R.id.eMailEditText).apply {
            form.eMail = text.toString()
        }

        findViewById<EditText>(R.id.passwordEditText).apply {
            form.password = text.toString()
        }

        if (form.checkAll()) {
            Snackbar.make(
                view,
                "${form.name} - ${form.eMail} - ${form.password}",
                Snackbar.LENGTH_LONG
            ).show()
        }
        else{

        }
    }
}