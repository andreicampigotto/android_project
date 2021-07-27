package com.firstprojectandroid.classes

class Veiculo (
    private val motor: String,
    var combustivel: String
    ){

    fun verificaMotor() {
        println(motor)
    }

    fun verificaCombustivel(){
        println(combustivel)
    }
}