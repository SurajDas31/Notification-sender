package com.virus.service;

import com.virus.model.NotificationRequest;
import com.virus.model.Status;

import java.util.List;

public interface NotificationService {

    NotificationRequest save(NotificationRequest notificationRequest);

    List<NotificationRequest> getAllNotificationByOpenStatus();

}
