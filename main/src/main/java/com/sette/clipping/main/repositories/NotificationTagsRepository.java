package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.NotificationTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationTagsRepository extends JpaRepository<NotificationTags, Integer>{
    
}
