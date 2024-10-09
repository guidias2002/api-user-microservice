package com.api.user.controller;

import com.api.user.dto.UserPostDto;
import com.api.user.message.UserKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserPostController {

    @Autowired
    private UserKafkaProducer userKafkaProducer;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserPostDto userPostDto){
        userKafkaProducer.sendUser(userPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
