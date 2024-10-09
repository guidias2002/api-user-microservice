package com.api.user.message;

import com.api.user.dto.UserPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserKafkaProducer {

    @Autowired
    private KafkaTemplate<String, UserPostDto> userkafkaTemplate;

    private final String USER_KAFKA_TOPIC = "user-post-topic";

    public void sendUser(UserPostDto userPostDto){
        userkafkaTemplate.send(USER_KAFKA_TOPIC, userPostDto);
    }

}
