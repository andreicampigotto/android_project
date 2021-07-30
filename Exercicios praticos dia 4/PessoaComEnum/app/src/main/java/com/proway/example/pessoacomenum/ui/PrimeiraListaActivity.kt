package com.proway.example.pessoacomenum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.pessoacomenum.R
import com.proway.example.pessoacomenum.adapter.AdapterListaNomes

class PrimeiraListaActivity : AppCompatActivity() {

    lateinit var recyclerViewNomes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_lista)

        val arrayNomes = arrayListOf("Andrei", "Joana", "Carolina", "João",
            "Maria", "Matheus", "Botão", "Arthur", "Felipe", "Jonathan")

        recyclerViewNomes = findViewById(R.id.recyclerViewNomes)
        recyclerViewNomes.adapter = AdapterListaNomes(arrayNomes)
        recyclerViewNomes.layoutManager = LinearLayoutManager(this)

    }
}