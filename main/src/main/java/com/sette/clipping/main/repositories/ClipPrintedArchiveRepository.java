package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipPrintedArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipPrintedArchiveRepository extends CrudRepository<ClipPrintedArchive, Integer> {
}
