package com.virus.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic_name}")
    private String KAFKA_TOPIC_NAME;

    @Value("${kafka.topic_partition}")
    private int KAFKA_TOPIC_PARTITION;

    @Bean
    public NewTopic notification_sender(){
        return TopicBuilder
                .name(KAFKA_TOPIC_NAME)
                .partitions(KAFKA_TOPIC_PARTITION)
                .build();
    }
}
