package com.store.demo.repository

import com.store.demo.model.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface StoresRepository : JpaRepository<Store?, Int?> {
    fun findByName(name: String?): List<Store?> //@Query("select store from Store store where store.id in(select select billing.storeId,sum(billing.totalAmount) as reg_sum from Billing billing group by billing.storeId)")
    //Store findTopStore();
}