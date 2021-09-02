package com.proway.injecao_depencia_com_api.service

import com.proway.injecao_depencia_com_api.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    fun getUser(): Call<List<User>>
}