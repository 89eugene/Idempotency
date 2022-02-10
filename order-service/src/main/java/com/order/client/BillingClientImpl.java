package com.order.client;


import com.order.client.dto.BillingRequest;
import com.order.client.dto.BillingResponse;
import com.order.utils.ClientResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Клиент сервиса auth
 */
@Component
@RequiredArgsConstructor
public class BillingClientImpl implements BillingClient {

    private final WebClient billingWebClient;

    @SneakyThrows
    public BillingResponse executeOperation(BillingRequest billingRequest) {
        return billingWebClient.put()
            .uri("/account/operation")
            .bodyValue(billingRequest)
            .retrieve()
            .onStatus(httpStatus -> httpStatus == HttpStatus.BAD_REQUEST,
                ClientResponseUtils::toErrorDtoBadRequestException)
            .onStatus(httpStatus -> httpStatus == HttpStatus.UNAUTHORIZED,
                ClientResponseUtils::toErrorUnauthorizedException)
            .onStatus(httpStatus -> httpStatus == HttpStatus.INTERNAL_SERVER_ERROR,
                ClientResponseUtils::toErrorDtoInternalServerException)
            .bodyToMono(BillingResponse.class)
            .block();
    }
}
