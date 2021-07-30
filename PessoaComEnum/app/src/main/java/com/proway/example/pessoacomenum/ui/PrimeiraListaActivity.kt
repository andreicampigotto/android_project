package com.proway.example.pessoacomenum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.pessoacomenum.R

class PrimeiraListaActivity : AppCompatActivity() {

    lateinit var recyclerViewNomes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_lista)

        recyclerViewNomes = findViewById(R.id.recyclerViewNomes)


        //recyclerViewNomes.

    }
}