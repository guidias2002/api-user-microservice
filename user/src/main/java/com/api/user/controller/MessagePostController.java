package com.api.user.controller;

import com.api.user.dto.MessagePostDto;
import com.api.user.message.MessageKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessagePostController {

    @Autowired
    private MessageKafkaProducer messageKafkaProducer;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody MessagePostDto messagePostDto){
        messageKafkaProducer.sendMessage(messagePostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
