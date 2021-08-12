package com.proway.usuariosapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.usuariosapi.adapter.AdapterProducts
import com.proway.usuariosapi.endpoint.RetrofitBuilder
import com.proway.usuariosapi.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<Product>> {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AdapterProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()
    }

    private fun loadComponents() {
        recyclerView = findViewById(R.id.productsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }

    private val productsCall by lazy {
        RetrofitBuilder.getProductServices().getProducts()
    }

    private fun fetchProducts() {
        productsCall.clone().enqueue(this)
    }

    override fun onResume() {
        super.onResume()
        fetchProducts()
    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        response.body()?.apply {
            adapter.update(this)
        }
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
    }
}