package com.person.config;

import com.person.config.props.ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Конфигурация интеграции с сервисом клиента
 */
@Configuration
public class WebClientBillingConfig {

    @Bean
    public WebClient webClient(ClientProperties clientProperties, WebClient.Builder builder) {
        return builder.baseUrl(clientProperties.getBillingservice().getUrl()).build();
    }
}
