package com.virus.service;

import com.virus.model.NotificationRequest;
import com.virus.model.Status;
import com.virus.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService{

    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationRequest save(NotificationRequest notificationRequest) {
        return notificationRepository.save(notificationRequest);
    }

    @Override
    public List<NotificationRequest> getAllNotificationByOpenStatus() {

        return notificationRepository.findAllByStatus(Status.OPEN.name());
    }

}
