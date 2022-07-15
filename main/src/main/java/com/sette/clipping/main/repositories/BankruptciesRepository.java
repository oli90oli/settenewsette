package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Bankruptcies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankruptciesRepository extends JpaRepository<Bankruptcies, Integer> {
}
