package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipTv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipTvRepository extends JpaRepository<ClipTv, Long>{

}
