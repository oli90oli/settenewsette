package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer>{
    
}
