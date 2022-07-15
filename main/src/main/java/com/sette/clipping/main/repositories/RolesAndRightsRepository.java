package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.RolesAndRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesAndRightsRepository extends JpaRepository<RolesAndRights, Integer> {
    
}
