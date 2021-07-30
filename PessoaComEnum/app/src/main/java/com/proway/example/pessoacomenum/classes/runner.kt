package com.proway.example.pessoacomenum.classes

import kotlin.math.ln

fun main(){
//    val pessoa = Pessoa("0101", "Andrei", tipoUsuario = TipoUsuario.Aluno)
//
//    println(pessoa)

    val nomes = arrayOf("Andrei", "Joana", "Carolina", "João",
        "Maria", "Matheus", "Botão", "Arthur", "Felipe", "Jonathan")

//    nomes.forEach{
//        println(it)
//    }

    nomes.filter{it.contains("na")}.sorted().forEach{
        println(it)
    }
}