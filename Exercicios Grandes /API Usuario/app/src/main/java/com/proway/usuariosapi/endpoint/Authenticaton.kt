package com.proway.usuariosapi.endpoint

import android.net.Credentials
import com.proway.usuariosapi.model.Auth
import com.proway.usuariosapi.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Authenticaton {

    //Aqui é onde autentica
    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}
