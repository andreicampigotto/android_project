package com.proway.crud_firebills.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.crud_firebills.database.dao.CategoryDao
import com.proway.crud_firebills.database.dao.ProductDao
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.model.Product

@Database(
    entities = [Product::class, Category::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "billsCRUD_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}
