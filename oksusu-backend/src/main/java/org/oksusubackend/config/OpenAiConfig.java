package org.oksusubackend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "openai")
public class OpenAiConfig {

    private final String apiKey = "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";

}