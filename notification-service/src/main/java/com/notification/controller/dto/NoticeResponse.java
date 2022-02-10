package com.notification.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class NoticeResponse {
    private String message;

    public NoticeResponse(){}

    public NoticeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NoticeResponse{" +
            "message='" + message + '\'' +
            '}';
    }
}
