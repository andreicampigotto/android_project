package com.proway.crud_firebills.database.dao

import androidx.room.*
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.model.Product
import com.proway.crud_firebills.model.ProductCategory

@Dao
interface ProductDao {

    @Transaction
    @Query("SELECT * FROM Product")
    fun getProducts(): List<ProductCategory>

    @Query("SELECT * FROM Product WHERE prod_id = :id")
    fun getProduct(id: Long): Product

    @Delete
    fun delete(product: Product)

    @Insert
    fun insert(product: Product)

    @Insert
    fun insert(category: Category): Long

    fun insert(productCategory: ProductCategory) {
        insert(productCategory.category!!)
        productCategory.product?.let {
            insert(it)
        }
    }

}