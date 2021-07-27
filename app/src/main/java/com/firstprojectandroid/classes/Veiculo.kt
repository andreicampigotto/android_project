package com.firstprojectandroid.classes

class Veiculo (
    private val motor: String,
    var combustivel: String
    ){
    constructor() : this("", "")

    fun verificaMotor() : Boolean  {
        return motor.length >= 2 && motor.isNotEmpty()
    }

    fun verificaCombustivel(){
        println(combustivel)
    }
}