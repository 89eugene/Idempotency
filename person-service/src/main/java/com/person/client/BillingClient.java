package com.person.client;


import com.person.client.dto.BillingCreateAccountRequest;
import com.person.client.dto.BillingResponce;

public interface BillingClient {

    BillingResponce createAccount(BillingCreateAccountRequest billingRequest);
}
