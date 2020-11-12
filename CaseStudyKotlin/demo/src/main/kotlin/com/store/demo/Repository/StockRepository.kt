package com.store.demo.Repository

import com.store.demo.model.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface StockRepository : JpaRepository<Stock?, Int?> {
    fun findByStoreId(id: Int): List<Stock?>?
    fun findByProductId(id: Int): List<Stock?>?

    @Query("select stock from Stock stock where stock.stock<=10")
    fun findByStock(): List<Stock?>?

    @Query("select stock from Stock stock where stock.productId=?1 and stock.storeId=?2")
    fun findByCondition(productId: Int, storeId: Int): Stock?
}