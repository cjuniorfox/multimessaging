package com.gft.multimessaging;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gft.multimessaging.service.MessageProcessorService;

@Component
@EnableScheduling
public class Scheduler {
    private final MessageProcessorService messageProcessor;

    public Scheduler(MessageProcessorService messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @Scheduled(fixedDelay = 10000) // Every 10 Seconds
    public void processMessages() {
        messageProcessor.processMessages();
    }

}
