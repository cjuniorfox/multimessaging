package com.gft.multimessaging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

@Service
public class MessageProcessorService {
    private static final int THREAD_POOL_SIZE = 5;
    private ExecutorService executor;
    private final List<String> messages;

    public MessageProcessorService() {
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void processMessages() {
        for (String message : messages) {
            executor.submit(() -> {
                System.out.println("Processing message: " + message);
                try {
                    // Simulates the process delay
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Message processed: " + message);
            });
        }
        messages.clear();

    }

    public void shutdown() {
        executor.shutdown();
    }
}
