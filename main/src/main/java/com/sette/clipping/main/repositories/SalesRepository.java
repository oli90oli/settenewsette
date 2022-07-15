package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
