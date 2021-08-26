package com.proway.crud_firebills.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cat_id")
    val id: Long = 0,

    @ColumnInfo(name = "cat_name")
    val name: String
) {
}