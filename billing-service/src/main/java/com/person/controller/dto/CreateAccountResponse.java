package com.person.controller.dto;


public class CreateAccountResponse {

    private boolean isSuccess;

    public CreateAccountResponse(){}

    public CreateAccountResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "CreateAccountResponse{" +
            "isSuccess=" + isSuccess +
            '}';
    }
}
