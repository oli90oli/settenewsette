package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.ClipTvArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipTvArchiveRepository extends CrudRepository<ClipTvArchive, Integer> {
}
