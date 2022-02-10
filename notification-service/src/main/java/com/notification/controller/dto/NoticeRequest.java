package com.notification.controller.dto;

public class NoticeRequest {

    private String login;


    public NoticeRequest(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "NoticeRequest{" +
            "login='" + login + '\'' +
            '}';
    }
}
