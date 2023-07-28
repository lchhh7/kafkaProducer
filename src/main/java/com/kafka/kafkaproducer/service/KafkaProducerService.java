package com.kafka.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private static int runningId = 0;

    private final KafkaTemplate kafkaTemplate;

    @Scheduled(fixedRate = 1000*10, initialDelay = 5*1000)
    public void produceMessage() {
        log.info("Produce Message - BEGIN");
        String message = String.format("%d 번째 메세지를 %s 에 전송 하였습니다.", runningId++, LocalDateTime.now().toString());
        CompletableFuture completableFuture = kafkaTemplate.send("testTopic", message);
        completableFuture.whenComplete((result , ex) -> {
            if(ex ==null) {
                log.info("SUCCESS!! This is the reulst: {}", result);
            } else {
                log.error("ERROR Kafka error happend", ex);
            }
        });
        log.info("Produce Message - END {}", message);
    }

}