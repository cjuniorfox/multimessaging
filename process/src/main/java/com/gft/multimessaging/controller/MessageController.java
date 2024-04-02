package com.gft.multimessaging.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.multimessaging.service.MessageProcessorService;

@RestController
public class MessageController {
    private final MessageProcessorService messageProcessor;

    @Autowired
    public MessageController(MessageProcessorService messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @PostMapping("/messages")
    public void receiveMessage(@RequestBody String message) {
        messageProcessor.addMessage(message);
        System.out.println("Received message: " + message);
    }

    @GetMapping("/process")
    public void processMessages() {
        messageProcessor.processMessages();
    }

}