package com.order.client.dto;

public class BillingRequest {

    private String login;
    private Double sum;
    private String operation;

    public BillingRequest(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "BillingRequest{" +
            "login='" + login + '\'' +
            ", sum=" + sum +
            ", operation='" + operation + '\'' +
            '}';
    }
}
