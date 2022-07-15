package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Authors;
import com.sette.clipping.main.model.Notifications;
import com.sette.clipping.main.services.NotificationsService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
        
    private  final NotificationsService notificationsService;
    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Notifications>> getAllNotifications() {
        List<Notifications> notifications = notificationsService.findAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationsByID(@PathVariable("id") int id) {
        Notifications notification = notificationsService.findNotifications(id);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Notifications> addNotifications(@RequestBody Notifications notification) {
        Notifications newNotification = notificationsService.addNotifications(notification);
        return new ResponseEntity<>(newNotification, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateNotifications(@PathVariable int id, @RequestBody Notifications notification){
        notificationsService.updateNotifications(id, notification);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotificationsByID(@PathVariable("id") int id) {
        notificationsService.deleteNotifications(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
