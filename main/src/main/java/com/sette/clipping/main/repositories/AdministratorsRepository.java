package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorsRepository extends JpaRepository<Administrators, Integer>{

}
