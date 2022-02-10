package com.order.client;

import com.order.client.dto.BillingRequest;
import com.order.client.dto.BillingResponse;

public interface BillingClient {

    BillingResponse executeOperation(BillingRequest billingRequest);
}
