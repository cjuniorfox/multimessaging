package com.gft.sqslistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;

@Service
public class SQSListenerSevice {

    @Autowired
    private ApiService apiService;

    @Value("${amazon.aws.sqs.queueUrl}")
    private String queueUrl;

    private final AmazonSQS sqs;

    public SQSListenerSevice(AmazonSQS sqs) {
        this.sqs = sqs;
    }

    public void listenToSQS() {
        for (Message message : sqs
                .receiveMessage(queueUrl)
                .getMessages()) {
            String body = message.getBody();
            apiService.postToApi(body);
            sqs.deleteMessage(queueUrl, message.getReceiptHandle());
        }
    }

}
