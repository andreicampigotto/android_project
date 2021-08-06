package com.proway.usuariosapi.endpoint

import android.net.Credentials
import com.proway.usuariosapi.model.Auth
import com.proway.usuariosapi.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceUser {

    @GET("/users/{userId}")
    fun getUsers(@Path("id") userId: Int): Call<List<User>>

    @GET("/users/")
    fun getAllUser(): Call<List<User>>

    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}
