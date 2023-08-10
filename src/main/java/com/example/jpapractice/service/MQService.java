package com.example.jpapractice.service;

import lombok.RequiredArgsConstructor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MQService {
    private final JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message, String name) {
        List<String> list = new ArrayList<>();

        for(int i=1; i<=10; i++){
            list.add(String.valueOf(i));
        }

        try{
            jmsTemplate.convertAndSend("queueName", list);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("FAIL");
        }
    }

    @JmsListener(destination = "queueName")
    public void receiveMessage(List message) {
        for(Object s : message){
            System.out.println("Received message: " + s);
        }
    }
}
