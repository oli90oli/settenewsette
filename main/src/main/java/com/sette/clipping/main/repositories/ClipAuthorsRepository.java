package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipAuthors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipAuthorsRepository extends JpaRepository<ClipAuthors, Integer>{

}
