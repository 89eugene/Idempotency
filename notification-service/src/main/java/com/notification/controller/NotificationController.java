package com.notification.controller;

import com.notification.controller.dto.NoticeResponse;
import com.notification.models.Notice;
import com.notification.repository.NoticeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notice")
public class NotificationController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices/")
    public ResponseEntity<List<NoticeResponse>> getAllNoticesByLogin( @RequestParam(value = "login") String login) {
        List<NoticeResponse> messages = noticeRepository.findAllByLogin(login).stream()
            .map(r -> new NoticeResponse(r.getMessage())).collect(Collectors.toList());
        return ResponseEntity.ok().body(messages);
    }

}