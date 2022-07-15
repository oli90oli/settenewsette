package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Mediums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediumsRepository extends JpaRepository<Mediums, Integer>{

}
