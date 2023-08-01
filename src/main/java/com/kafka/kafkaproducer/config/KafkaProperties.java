package com.kafka.kafkaproducer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.kafka")
@Getter
@Setter
public class KafkaProperties {
    private String bootStrapServers;
}