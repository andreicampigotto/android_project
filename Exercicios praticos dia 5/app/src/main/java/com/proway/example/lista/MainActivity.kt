package com.proway.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.lista.Adapter.AdapterRecyclerView
import com.proway.example.lista.model.Car

class MainActivity : AppCompatActivity() {

    private lateinit var carRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfCars = listOf(
            Car("GMC", "Tracker", 2017 ),
            Car("GMC","Cruze", 2014),
            Car("Hyundai", "HB20", 2019),
            Car("Volvo", "S60", 2016),
            Car("fiat", "Strada", 2010),
            Car("Lincon", "Suburban", 2019)
        )

        carRecyclerView = findViewById(R.id.carsRecycleView)
        carRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        carRecyclerView.adapter = AdapterRecyclerView(listOfCars)
    }
}