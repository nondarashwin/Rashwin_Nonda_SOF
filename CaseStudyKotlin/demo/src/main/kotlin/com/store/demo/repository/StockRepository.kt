package com.store.demo.repository

import com.store.demo.model.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import com.store.demo.model.BilledProduct

@Repository
interface StockRepository : JpaRepository<Stock?, Int?> {
    fun findByStoreId(id: Int): List<Stock?>?
    fun findByProductId(id: Int): List<Stock?>?

    @Query("select stock from Stock stock where stock.stock<=(select avg(billedProduct.quantity) from BilledProduct billedProduct where billedProduct.productId=stock.productId)")
    fun findByStock(): List<Stock?>?
    //select stock from Stock stock where stock.stock<=(select avg(billingProuct.quantity) from BillingProduct billingProduct where billingProduct.productId=stock.productId);
    @Query("select stock from Stock stock where stock.productId=?1 and stock.storeId=?2")
    fun findByCondition(productId: Int, storeId: Int): Stock?
}