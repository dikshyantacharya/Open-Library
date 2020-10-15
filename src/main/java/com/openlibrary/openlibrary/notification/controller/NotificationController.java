package com.openlibrary.openlibrary.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openlibrary.openlibrary.notification.service.NotificationService;
import com.openlibrary.openlibrary.notification.DTO.CreateNotificationDTO;
import com.openlibrary.openlibrary.notification.DTO.NotificationDTO;
import com.openlibrary.openlibrary.notification.entity.NotificationEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notification")

public class NotificationController {
    @Autowired
    NotificationService service;
    
    @GetMapping("/findNotification/{userId}/{id}")
    public ResponseEntity<NotificationDTO> getSentNotificaation(@PathVariable long userId, @PathVariable long id) throws Exception {
        return new ResponseEntity<NotificationDTO>(service.findSentNotificaitonOfId(userId, id), HttpStatus.OK);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<List<NotificationDTO>> getAllNotification(@PathVariable long userId) throws Exception {
        return new ResponseEntity<List<NotificationDTO>>(service.getAllNotification(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{id}")
    public HttpStatus deleteNotification(@PathVariable long userId, @PathVariable long id) {
        service.deleteNotification(userId, id);
        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping("/{userId}")
    public HttpStatus deleteNotification(@PathVariable long userId) {
        service.deleteAllNotification(userId);
        return HttpStatus.NO_CONTENT;
    }
  
    @PostMapping
    public ResponseEntity<NotificationEntity> createNotification(@RequestBody CreateNotificationDTO notificationDTO) {
        return new ResponseEntity<NotificationEntity>(service.createNotification(notificationDTO), HttpStatus.OK);
    }
}