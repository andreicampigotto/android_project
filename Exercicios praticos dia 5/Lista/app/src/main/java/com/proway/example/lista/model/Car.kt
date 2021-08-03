package com.proway.example.lista.model

import java.io.Serializable

data class Car(
    val marca: String,
    val modelo: String,
    val ano: Int,
    val logo: CarLogoUrl
) : Serializable{

}