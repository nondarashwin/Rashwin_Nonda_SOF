package com.store.demo.repository

import com.store.demo.model.Bill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BillsRepository : JpaRepository<Bill?, Int?>
