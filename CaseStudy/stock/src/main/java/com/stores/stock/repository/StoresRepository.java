package com.stores.stock.repository;

import com.stores.stock.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends JpaRepository<Store, Integer> {
}
