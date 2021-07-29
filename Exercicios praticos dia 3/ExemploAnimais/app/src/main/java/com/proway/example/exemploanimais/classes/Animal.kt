package com.proway.example.exemploanimais.classes

abstract class Animal(
    val categoria: String
) : Som, Movimento {
    open fun movimentar(){
        println("animal se movimenta")
    }
}