package com.kafka.kafkaproducer.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


@ConfigurationProperties("spring.kafka")
@Getter
@Setter
public class KafkaProperties {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;
}