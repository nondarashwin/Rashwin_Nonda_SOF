package com.store.demo.Repository

import com.store.demo.model.BilledProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface BilledProductsRepository : JpaRepository<BilledProduct?, Int?> {
    fun findByBillId(id: Int): List<BilledProduct?>?
}