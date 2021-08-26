package com.proway.crud_firebills.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.crud_firebills.database.AppDatabase
import com.proway.crud_firebills.model.Category
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CategoryDaoTest{

    private lateinit var database: AppDatabase
    private lateinit var dao: CategoryDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.categoryDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insert_category_returns_true(){
        val category1= Category(1L, "Eletronico")
        val category2= Category(2L, "Bazar")
        val category3= Category(3L, "Higienie")

        val listToInsert= arrayListOf(category1, category2, category3)
        dao.insert(listToInsert)

        val result = dao.getCategory()
        assertThat(result).containsExactlyElementsIn(listToInsert)
    }
}