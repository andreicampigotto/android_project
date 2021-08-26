package com.proway.crud_firebills.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import com.proway.crud_firebills.database.AppDatabase
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.model.Product
import com.proway.crud_firebills.model.ProductCategory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: ProductDao


    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDao()
    }

    @After
    fun tearown(){
        database.close()
    }

    @Test
    fun insert_category_returns_true(){
        val c1 = Category(5L, "Eletric")
        val p1 = Product(20L, "TV", 100.0, c1.id)
        val productWhithCategory = ProductCategory(product = p1, category = c1)

        dao.insert(productWhithCategory)

        val result = dao.getProducts()
        Truth.assertThat(result).contains(productWhithCategory)
    }

}