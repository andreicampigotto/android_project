package com.proway.sharedpreferences.model

data class User(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val name: Name,
    val address: Address,
    val phone: String
) {

    fun checkUserName(): Boolean {
        return !username.isNullOrEmpty()
    }

    fun checkPassword(): Boolean {
        return !password.isNullOrEmpty()
    }
}

data class Name(
    val firstname : String,
    val lastname : String
)

data class Address(
    val city : String,
    val street : String,
    val number: Int,
    val zipcode: String,
    val geolocation: Geolocation,
)

data class Geolocation(
    val lat : String,
    val long: String
)