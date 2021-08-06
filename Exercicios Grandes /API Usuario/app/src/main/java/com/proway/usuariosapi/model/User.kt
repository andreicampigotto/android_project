package com.proway.usuariosapi.model

data class User(
    val id : Int,
    val username : String,
    val password: String,
    val name: Name,
    val address: Address,
    val phone : String
) {
}