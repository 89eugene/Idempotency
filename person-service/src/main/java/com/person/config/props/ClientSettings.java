package com.person.config.props;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientSettings {

    /**
     * URL сервиса-клиента
     */
    private String url;
}
