package com.stores.stock.repository;

import com.stores.stock.model.BilledProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilledProductsRepository extends JpaRepository<BilledProduct, Integer> {
}
