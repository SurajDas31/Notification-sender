package com.virus.controller;

import com.virus.model.NotificationRequest;
import com.virus.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("send")
    public ResponseEntity send(@Valid @RequestBody NotificationRequest notificationRequest){
        NotificationRequest savedNotificationRequest = notificationService.save(notificationRequest);
        return new ResponseEntity(savedNotificationRequest, HttpStatus.CREATED);
    }

}
