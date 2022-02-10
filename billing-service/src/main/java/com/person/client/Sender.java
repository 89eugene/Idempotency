package com.person.client;

import com.person.client.dto.Message;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Data
@NoArgsConstructor
public class Sender {

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void send(Message message) {
        kafkaTemplate.send(topic, message);
    }
}