package com.virus.repository;

import com.virus.model.NotificationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends MongoRepository<NotificationRequest, UUID> {

    List<NotificationRequest> findAllByStatus(String status);

}
