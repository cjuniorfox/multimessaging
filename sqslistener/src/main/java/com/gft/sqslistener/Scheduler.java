package com.gft.sqslistener;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gft.sqslistener.service.SQSListenerSevice;

@Component
@EnableScheduling
public class Scheduler {
    private final SQSListenerSevice sqsListener;

    public Scheduler(SQSListenerSevice sqsListener) {
        this.sqsListener = sqsListener;
    }

    @Scheduled(fixedDelay = 1000) // Run every seconds
    public void runSqsListener() {
        sqsListener.listenToSQS();
    }
}
