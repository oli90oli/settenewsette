package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Clients;
import com.sette.clipping.main.model.Notifications;
import com.sette.clipping.main.repositories.NotificationsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {
       
    private final NotificationsRepository notificationsRepository;
       
        @Autowired
        public NotificationsService(NotificationsRepository notificationsRepository) {
            this.notificationsRepository = notificationsRepository;
        }
        
        public Notifications addNotifications(Notifications notifications) {
            return notificationsRepository.save(notifications);
        }
        
        public List<Notifications> findAllNotifications() {
            return notificationsRepository.findAll();
        }
        
        public void updateNotifications(int id, Notifications notifications) {
            Notifications notification = this.findNotifications(id);
            if(!notifications.getNotification_medium().equals("")) {
                notification.setNotification_medium(notifications.getNotification_medium());
            }
            if(!notifications.getNotification_publisher().equals("")) {
                notification.setNotification_publisher(notifications.getNotification_publisher());
            }
            if(!notifications.getNotification_subject().equals("")) {
                notification.setNotification_subject(notifications.getNotification_subject());
            }
            if(!notifications.getNotification_holder().equals("")) {
                notification.setNotification_holder(notifications.getNotification_holder());
            }
            if(!notifications.getNotification_url().equals("")) {
                notification.setNotification_url(notifications.getNotification_url());
            }
            if(!notifications.getNotification_description().equals("")) {
                notification.setNotification_description(notifications.getNotification_description());
            }
            if(!notifications.getNotification_date().equals("")) {
                notification.setNotification_date(notifications.getNotification_date());
            }
            notificationsRepository.save(notification);
        }
        
        public Notifications findNotifications(int id) {
            return this.findAllNotifications().stream().filter(t -> t.getNotification_id()== id).findFirst().get();
     }
        
        public void deleteNotifications(int id) {
            notificationsRepository.deleteById(id);
        }
}   
