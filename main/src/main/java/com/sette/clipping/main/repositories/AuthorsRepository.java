package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer>{
 
}
