package com.person.client;


import com.person.client.dto.BillingCreateAccountRequest;
import com.person.client.dto.BillingResponce;
import com.person.utils.ClientResponseUtils;
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
    public BillingResponce createAccount(BillingCreateAccountRequest billingRequest) {
        return billingWebClient.post()
            .uri("/account/createAccount")
            .bodyValue(billingRequest)
            .retrieve()
            .onStatus(httpStatus -> httpStatus == HttpStatus.BAD_REQUEST,
                ClientResponseUtils::toErrorDtoBadRequestException)
            .onStatus(httpStatus -> httpStatus == HttpStatus.UNAUTHORIZED,
                ClientResponseUtils::toErrorUnauthorizedException)
            .onStatus(httpStatus -> httpStatus == HttpStatus.INTERNAL_SERVER_ERROR,
                ClientResponseUtils::toErrorDtoInternalServerException)
            .bodyToMono(BillingResponce.class)
            .block();
    }
}
