package com.proway.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.example.lista.model.Car

class DetailCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_car)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val car = intent.getSerializableExtra("parametro_carro") as? Car

        car?.let { myCar ->

            supportActionBar?.title = "${myCar.marca} - ${myCar.modelo}"

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}