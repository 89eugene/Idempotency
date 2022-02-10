package com.person.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class BalanceResponse {
    private int code;
    private boolean isPaid = true;
    private String message;

    public BalanceResponse(){}

    public BalanceResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
            "code=" + code +
            ", isPaid=" + isPaid +
            ", message='" + message + '\'' +
            '}';
    }
}
