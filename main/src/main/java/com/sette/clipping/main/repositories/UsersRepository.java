package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    //Users findByUsername(String user_username);
}
