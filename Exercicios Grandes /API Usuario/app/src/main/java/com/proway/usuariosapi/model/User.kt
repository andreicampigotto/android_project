package com.proway.usuariosapi.model

import android.provider.ContactsContract

data class User(
    val id : Int,
    val email: String,
    val username : String,
    val password: String,
    val name: Name,
    val address: Address,
    val phone : String
) {

    fun checkUserName(): Boolean{
        return !username.isNullOrEmpty()
    }

    fun checkPassword(): Boolean{
        return !password.isNullOrEmpty()
    }
}