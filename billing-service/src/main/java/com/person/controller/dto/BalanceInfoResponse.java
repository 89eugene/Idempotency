package com.person.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class BalanceInfoResponse {

    private Double summary;

    public BalanceInfoResponse(){}

    public BalanceInfoResponse(Double summary) {
        this.summary = summary;
    }

    public Double getSummary() {
        return summary;
    }

    public void setSummary(Double summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "BalanceInfoResponse{" +
            "summary=" + summary +
            '}';
    }
}
