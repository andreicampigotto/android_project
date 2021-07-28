package com.firstprojectandroid.classes

class Veiculo (
    private val motor: String,
    var combustivel: String
    ){
    constructor() : this("", "")

    fun verificaMotor() : Boolean  {
        return motor.isNotEmpty() && motor.length >= 2
    }

    fun verificaCombustivel(){
        println(combustivel)
    }
}