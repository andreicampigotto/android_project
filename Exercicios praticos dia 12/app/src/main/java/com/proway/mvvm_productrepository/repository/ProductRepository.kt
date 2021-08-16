package com.proway.mvvm_productrepository.repository

import com.proway.mvvm_productrepository.model.Product
import com.proway.mvvm_productrepository.services.RetrofitBuilder
import retrofit2.Callback

class ProductRepository {

    private val service = RetrofitBuilder.getInstance()

    fun getProducts(callBack: Callback<List<Product>>) {
        val call = service.getProducts()
        call.enqueue(callBack)
    }
}