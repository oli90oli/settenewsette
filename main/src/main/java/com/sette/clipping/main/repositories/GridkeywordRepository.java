package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Gridkeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridkeywordRepository extends JpaRepository<Gridkeyword, Integer>{
    
}
