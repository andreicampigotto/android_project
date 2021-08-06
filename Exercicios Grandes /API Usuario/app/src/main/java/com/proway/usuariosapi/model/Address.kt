package com.proway.usuariosapi.model

data class Address(
    val city : String,
    val street : String,
    val number: Int,
    val zipcode: String,
    val geolocation: Geolocation,
) {
}