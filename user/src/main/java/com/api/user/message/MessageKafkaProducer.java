package com.api.user.message;

import com.api.user.dto.MessagePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageKafkaProducer {

    @Autowired
    private KafkaTemplate<String, MessagePostDto> messagekafkaTemplate;

    private final String MESSAGE_KAFKA_TOPIC = "message-post-topic";

    public void sendMessage(MessagePostDto messagePostDto){
        messagekafkaTemplate.send(MESSAGE_KAFKA_TOPIC, messagePostDto);
    }
}
