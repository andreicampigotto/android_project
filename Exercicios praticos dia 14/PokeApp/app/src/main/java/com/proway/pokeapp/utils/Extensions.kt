package com.proway.pokeapp.utils

fun String.toUpperFirstChar(): String{
    return replaceFirstChar { it.uppercase() }
}