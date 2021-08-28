package com.proway.crud_firebills.repository

import android.content.Context
import com.proway.crud_firebills.database.AppDatabase
import com.proway.crud_firebills.database.dao.CategoryDao
import com.proway.crud_firebills.model.Category

class CategoryRepository(val context: Context) {

    private val dao: CategoryDao = AppDatabase.getDatabase(context).categoryDao()

    fun getCategories(): List<Category>{
        return dao.getCategories()
    }

    fun insert(category: Category){
        return dao.insert(arrayListOf(category))
    }
}
