package com.notification.client;

import com.notification.client.dto.Message;
import com.notification.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

    @Autowired
    private NoticeService noticeService;

    @KafkaListener(topics = "${kafka.topic}")
    public void receive(Message message) {
        noticeService.createNotice(message);
    }
}
