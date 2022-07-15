package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Tenders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TendersRepository extends JpaRepository<Tenders, Integer>{
    
}
