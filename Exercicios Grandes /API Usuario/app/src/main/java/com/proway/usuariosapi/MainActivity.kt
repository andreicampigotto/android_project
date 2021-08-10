package com.proway.usuariosapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.usuariosapi.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<Product>>  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
        TODO("Not yet implemented")
    }
}