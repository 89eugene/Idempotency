package com.order.client.dto;

public class BillingResponse {

    private String login;
    private boolean isPaid;

    public BillingResponse(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean getPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "BillingResponse{" +
            "login='" + login + '\'' +
            ", isPaid=" + isPaid +
            '}';
    }
}
