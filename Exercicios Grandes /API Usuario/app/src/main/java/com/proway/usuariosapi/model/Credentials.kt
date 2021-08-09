package com.proway.usuariosapi.model

import com.google.gson.annotations.SerializedName

data class Credentials(

    @SerializedName("username")
    val username: String,

    val password: String
) {

}