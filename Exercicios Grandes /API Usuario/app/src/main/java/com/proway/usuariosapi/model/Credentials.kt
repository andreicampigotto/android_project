package com.proway.usuariosapi.model

import com.google.gson.annotations.SerializedName

data class Credentials(

    @SerializedName("username")
    val username: String,

    val password: String
) {
    fun checkUsername(): Boolean{
        return !username.isNullOrEmpty()
    }

    fun checkPassword(): Boolean{
        return !password.isNullOrEmpty()
    }

}