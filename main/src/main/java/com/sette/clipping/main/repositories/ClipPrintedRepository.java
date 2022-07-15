package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipPrinted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipPrintedRepository extends JpaRepository<ClipPrinted, Long>{

}
