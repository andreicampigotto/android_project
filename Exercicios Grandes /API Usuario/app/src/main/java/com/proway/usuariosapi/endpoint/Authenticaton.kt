package com.proway.usuariosapi.endpoint

import com.proway.usuariosapi.model.Auth
import com.proway.usuariosapi.model.Credentials
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Authenticaton {

    //Aqui é onde autentica
    @POST("/auth/login")
    fun login(@Body credentials: Credentials): Call<Auth>
}
