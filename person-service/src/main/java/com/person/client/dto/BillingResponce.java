package com.person.client.dto;

public class BillingResponce {

    private boolean isSuccess;

    public BillingResponce(){}

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "BillingResponce{" +
            "isSuccess=" + isSuccess +
            '}';
    }
}
