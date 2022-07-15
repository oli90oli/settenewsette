package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipGroupRepository extends JpaRepository<ClipGroup, Integer>{

}
