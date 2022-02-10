package com.order.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("clients")
@Getter
@Setter
public class ClientProperties {

    /**
     * Настройки сервиса-клиента auth
     */
    private ClientSettings billingservice;
}
