package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Tenders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ENabavkiRepository extends JpaRepository<Tenders, Integer> {

    @Query(value = "select * from return_json_news()", nativeQuery = true)
    List<Tenders> getNewsJsonFunction();


    @Query(value = "select * from getallnewsdata()", nativeQuery = true)
    List<Tenders> getProcedures();
}
