package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.NotificationTags;
import com.sette.clipping.main.model.TenderTags;
import com.sette.clipping.main.services.NotificationTagsService;
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
@RequestMapping("/notification-tags")
public class NotificationTagsController {
    
    private final NotificationTagsService notificationTagsService;
    public NotificationTagsController(NotificationTagsService notificationTagsService){
        this.notificationTagsService = notificationTagsService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<NotificationTags>> getAllNotificationTags() {
        List<NotificationTags> notificationTag = notificationTagsService.findAllNotificationTags();
        return new ResponseEntity<>(notificationTag, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationTags> getNotificationTagByID(@PathVariable("id") int id) {
        NotificationTags notificationTag = notificationTagsService.findNotificationTag(id);
        return new ResponseEntity<>(notificationTag, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<NotificationTags> addNotificationTag(@RequestBody NotificationTags notificationTag) {
        NotificationTags newNotificationTag = notificationTagsService.addNotificationTags(notificationTag);
        return new ResponseEntity<>(newNotificationTag, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateNotificationTag(@PathVariable int id, @RequestBody NotificationTags notificationTag){
        notificationTagsService.updateNotificationTag(id, notificationTag);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotificationTagByID(@PathVariable("id") int id) {
        notificationTagsService.deleteNotificationTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
