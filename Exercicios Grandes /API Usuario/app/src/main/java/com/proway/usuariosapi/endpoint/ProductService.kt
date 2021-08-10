package com.proway.usuariosapi.endpoint

import android.net.Credentials
import com.proway.usuariosapi.model.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    fun getProducts(@Body credentials: Credentials): List<Product>

}