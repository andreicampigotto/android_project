package com.firstprojectandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firstprojectandroid.R
import com.firstprojectandroid.classes.Pessoa
import com.firstprojectandroid.classes.Veiculo

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        Pessoa(nome = "Andrei", eMail = "andrei@gmail.com").apply {
            validaEMail(eMail)
            concatenaNome("$nome").let {
                println(it)
            }
        }
    }
}