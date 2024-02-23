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

    private final String apiKey = "Open AI API Key - OpenAI 설정 페이지에서 확인";

}