package com.proway.ciclodevida.singleton

import com.proway.ciclodevida.model.Produto
import java.util.*

object ListaControle {
    val produtos: MutableList<Produto> = mutableListOf(
        Produto(UUID.randomUUID().toString(), "Wisky", 79.99f),
        Produto(UUID.randomUUID().toString(), "Cerveja", 3.99f),
        Produto(UUID.randomUUID().toString(), "Cuca", 12.99f),
        Produto(UUID.randomUUID().toString(), "Bruscheta", 14.99f),
        Produto(UUID.randomUUID().toString(), "Wisky", 89.99f),
    )
}