package com.notification.service;

import com.notification.client.dto.Message;
import com.notification.models.Notice;
import com.notification.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public void createNotice(Message message){
        Notice notice = new Notice();
        notice.setMessage(message.getMessage());
        notice.setLogin(message.getLogin());

        noticeRepository.save(notice);
    }

}
