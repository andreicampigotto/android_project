package com.proway.example.lista.Adapter

import com.proway.example.lista.model.Car

interface ClickableItem {
    fun onDelete(car:Car)
    fun onEdit(car: Car)
}