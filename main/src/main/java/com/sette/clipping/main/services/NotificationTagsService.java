package com.sette.clipping.main.services;

import com.sette.clipping.main.model.NotificationTags;
import com.sette.clipping.main.repositories.NotificationTagsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationTagsService {
        
        private final NotificationTagsRepository notificationTagsRepository;
       
        @Autowired
        public NotificationTagsService(NotificationTagsRepository notificationTagsRepository) {
            this.notificationTagsRepository = notificationTagsRepository;
        }
        
        public NotificationTags addNotificationTags(NotificationTags notificationTag) {
            return notificationTagsRepository.save(notificationTag);
        }
        
        public List<NotificationTags> findAllNotificationTags() {
            return notificationTagsRepository.findAll();
        }
        
        public void updateNotificationTag(int id, NotificationTags notificationTag) {
            NotificationTags nTag = this.findNotificationTag(id);
            if(notificationTag.getNotification_tag_id()!= -1) {
                nTag.setNotification_tag_id(notificationTag.getNotification_tag_id());
            }
            if(notificationTag.getNotification_id()!= -1) {
                nTag.setNotification_id(notificationTag.getNotification_id());
            }
            if(notificationTag.getTag_id()!= -1) {
                nTag.setTag_id(notificationTag.getTag_id());
            }
            notificationTagsRepository.save(nTag);
        }
        
       public NotificationTags findNotificationTag(int id) {
            return this.findAllNotificationTags().stream().filter(t -> t.getNotification_tag_id()== id).findFirst().get();
     } 
        
        public void deleteNotificationTag(int id) {
            notificationTagsRepository.deleteById(id);
        } 
}
