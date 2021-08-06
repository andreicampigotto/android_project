package com.proway.usuariosapi.model

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("token")
    val token: String
)
