package com.example.jpapractice.service;

import lombok.RequiredArgsConstructor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MQService {
    private final JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message, int i, String name) {
        try{
            jmsTemplate.convertAndSend("queueName", "Hello World! " + i + " " + name);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("FAIL");
        }
    }

    @JmsListener(destination = "queueName")
    public void receiveMessage(String message) {
        System.out.println("Received message: " +message);
    }
}
