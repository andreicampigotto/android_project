package com.proway.curl_routines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>){
    runBlocking {
        testeRun()
    }
    println("Comecou")
}

suspend fun testeRun(){
    for (i in 0..17){
        delay(1000)
        println("Nome... $i")
    }
}