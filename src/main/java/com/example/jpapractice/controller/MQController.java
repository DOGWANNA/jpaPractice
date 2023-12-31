package com.example.jpapractice.controller;

import com.example.jpapractice.service.MQService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
@RequiredArgsConstructor
public class MQController {
    private final MQService mqService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message,
                              @RequestParam("destination") String destination,
                              @RequestParam("name") String name
    ){
            mqService.sendMessage(destination,message, name);
        return "succcess";
    }
}
