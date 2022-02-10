package com.person.client.dto;

public class BillingCreateAccountRequest {

    private String login;

    public BillingCreateAccountRequest(){}

    public BillingCreateAccountRequest(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "BillingCreateAccountRequest{" +
            "login='" + login + '\'' +
            '}';
    }
}
