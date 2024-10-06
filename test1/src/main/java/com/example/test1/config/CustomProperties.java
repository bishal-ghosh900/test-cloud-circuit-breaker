package com.example.test1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("custom")
public class CustomProperties {
    private String buildVersion;
    private String javaVersion;
}
