package com.virus.service;

import com.virus.model.NotificationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaService {

    @Value("${kafka.topic_name}")
    private String KAFKA_TOPIC_NAME;

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ListenableFuture<SendResult<String, String>> send(NotificationRequest notificationRequest) {
        ListenableFuture<SendResult<String, String>> send = this.kafkaTemplate.send(KAFKA_TOPIC_NAME, notificationRequest.toString());
        return send;
    }
}
