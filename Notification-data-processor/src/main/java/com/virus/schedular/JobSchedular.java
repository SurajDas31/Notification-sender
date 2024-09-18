package com.virus.schedular;

import com.virus.model.NotificationRequest;
import com.virus.model.Status;
import com.virus.service.KafkaService;
import com.virus.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class JobSchedular {

    private NotificationService notificationService;

    private KafkaService kafkaService;

    public JobSchedular(NotificationService notificationService, KafkaService kafkaService) {
        this.notificationService = notificationService;
        this.kafkaService = kafkaService;
    }

    @Async
    @Scheduled(cron = "* * * * * *")
    public void createJobForSendingEmail() throws InterruptedException, ExecutionException {
        List<NotificationRequest> notificationByOpenStatus = notificationService.getAllNotificationByOpenStatus();
        for(NotificationRequest notificationRequest : notificationByOpenStatus){
            // Send to Kafka topics
            ListenableFuture<SendResult<String, String>> send = kafkaService.send(notificationRequest);
            log.info(send.get().toString());
            // Update the status of Notification to IN_PROCESS
            notificationRequest.setStatus(Status.IN_PROCESS);
            notificationService.save(notificationRequest);
        }
    }
}
