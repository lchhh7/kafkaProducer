package com.kafka.kafkaproducer.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("kafka")
@Getter
@Setter
public class KafkaProperties {
    @Value("localhost:9092")
    private String bootStrapServers;
}