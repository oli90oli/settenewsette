package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipTagRepository extends JpaRepository<ClipTag, Integer>{


}
