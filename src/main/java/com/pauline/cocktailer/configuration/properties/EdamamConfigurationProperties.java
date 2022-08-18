package com.pauline.cocktailer.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "edamam")
@Getter
@Setter
public class EdamamConfigurationProperties {

    private String scheme;
    private String host;
    private String path;
    private String appId;
    private String AppKey;
}
