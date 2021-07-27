package com.firstprojectandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstprojectandroid.R
import com.firstprojectandroid.classes.Veiculo

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val veiculo = Veiculo( "v6", "Alcool")

        veiculo.verificaMotor()
    }
}