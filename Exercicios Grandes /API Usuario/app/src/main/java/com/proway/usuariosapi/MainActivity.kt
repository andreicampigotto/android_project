package com.proway.usuariosapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.usuariosapi.model.Product
import retrofit2.Callback

class MainActivity : AppCompatActivity(), Callback<List<Product>>  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
}