package com.proway.crud_firebills.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.proway.crud_firebills.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM Category")
    fun getCategory() : List<Category>

    @Insert
    fun insert(list: List<Category>)
}