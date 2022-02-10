package com.person.config;

import com.person.config.props.ClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ClientProperties.class
})
public class PropertyConfig {
}
