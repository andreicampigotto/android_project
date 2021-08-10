package com.proway.usuariosapi.model

import com.google.gson.annotations.SerializedName

data class Auth(

    //Esse aqui e um LoginResponse
    @SerializedName("token")
    val token: String?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("msg")
    val msg: String?
){
    fun isError(): Boolean{
        return token.isNullOrEmpty()
    }
}
