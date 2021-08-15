package com.proway.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.myapplication.R
import com.proway.myapplication.adapter.ProductAdapter
import com.proway.myapplication.model.Product
import com.proway.myapplication.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaProdutosFragment : Fragment(), Callback<List<Product>> {

    lateinit var recyclerView: RecyclerView

    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista_produtos, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.productsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        fetchProducts()
    }

    private val productsCall by lazy {
        RetrofitBuilder.getInstance().getProducts()
    }

    override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
        response.body()?.apply {
            adapter.update(this)
        }
    }

    private fun fetchProducts() {
        productsCall.clone().enqueue(this)
    }

    override fun onFailure(call: Call<List<Product>>, t: Throwable) {
    }
}