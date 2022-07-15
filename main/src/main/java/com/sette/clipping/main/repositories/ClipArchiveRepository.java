package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipArchiveRepository extends CrudRepository<ClipArchive, Integer> {
}
