package com.proway.crud_firebills.model

data class Product(
    val id: String,
    val name : String,
    val price: String,
    val category: Category
) {
}