package com.stores.stock.repository;

import com.stores.stock.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Integer> {
}
