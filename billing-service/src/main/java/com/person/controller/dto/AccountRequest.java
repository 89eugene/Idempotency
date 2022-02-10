package com.person.controller.dto;

import com.person.models.Operation;

public class AccountRequest {

    private String login;
    private Double sum;
    private Operation operation;

    public AccountRequest(){}

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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
            "login='" + login + '\'' +
            ", sum=" + sum +
            ", operation=" + operation +
            '}';
    }
}
