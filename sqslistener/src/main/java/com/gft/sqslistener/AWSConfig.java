package com.gft.sqslistener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class AWSConfig {

    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                "accesskey",
                "secretkey");
        return credentials;
    }

    @Bean
    public AmazonSQS amazonSQS() {
        return AmazonSQSClientBuilder
                .standard()
                .withEndpointConfiguration(getEndpointConfiguration("http://localhost:4566"))
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(String url) {
        return new AwsClientBuilder.EndpointConfiguration(url, Regions.SA_EAST_1.getName());
    }

}