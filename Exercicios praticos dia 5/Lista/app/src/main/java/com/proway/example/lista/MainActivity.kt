package com.proway.example.lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.example.lista.Adapter.AdapterRecyclerView
import com.proway.example.lista.Adapter.ClickableItem
import com.proway.example.lista.model.Car
import com.proway.example.lista.model.CarLogoUrl

class MainActivity : AppCompatActivity(), ClickableItem {

    private lateinit var carRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfCars = mutableListOf(
            Car("GMC", "Tracker", 2017 , CarLogoUrl.GM),
            Car("GMC","Cruze", 2014, CarLogoUrl.GM),
            Car("Hyundai", "HB20", 2019, CarLogoUrl.Hyundai),
            Car("Volvo", "S60", 2016, CarLogoUrl.Volvo),
            Car("FIAT", "Strada", 2010, CarLogoUrl.FIAT),
            Car("Lincoln", "Suburban", 2019, CarLogoUrl.LinconLn)
        )

        val adapter = AdapterRecyclerView(listOfCars, this)

        carRecyclerView = findViewById(R.id.carsRecyclerView)
        carRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        carRecyclerView.adapter = adapter
    }

    fun onClickAddNewCar() {
        if (carRecyclerView.adapter is AdapterRecyclerView) {
            (carRecyclerView.adapter as AdapterRecyclerView).add(
                Car(
                    "Jeep",
                    "Renegade",
                    2021,
                    CarLogoUrl.JEEP
                )
            )
        }
    }

    override fun onDelete(car: Car) {
        if(carRecyclerView.adapter is AdapterRecyclerView){
            (carRecyclerView.adapter as AdapterRecyclerView).removeAt(car)
        }
    }

    override fun onEdit(car: Car) {
        val intentParaDetalhesDoCarro = Intent(this, DetailCarActivity::class.java)
        intentParaDetalhesDoCarro.putExtra("parametro_carro", car)
        startActivity(intentParaDetalhesDoCarro)
    }
}