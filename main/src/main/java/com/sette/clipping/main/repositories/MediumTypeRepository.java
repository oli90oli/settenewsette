package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.MediumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumTypeRepository extends JpaRepository<MediumType, Integer>{
  
}
