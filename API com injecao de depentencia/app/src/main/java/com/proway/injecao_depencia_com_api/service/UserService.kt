package com.proway.injecao_depencia_com_api.service

import com.proway.injecao_depencia_com_api.model.User
import retrofit2.Call
import retrofit2.http.GET

// Site: https://api.github.com/users
interface UserService {
    @GET("/users")
    fun getUser(): Call<List<User>>
}