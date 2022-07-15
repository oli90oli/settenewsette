package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer>{

}
