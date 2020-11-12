package com.store.demo.Repository

import com.store.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface ProductRepository : JpaRepository<Product?, Int?> {
    fun findByName(name: String?): List<Product?>?
}