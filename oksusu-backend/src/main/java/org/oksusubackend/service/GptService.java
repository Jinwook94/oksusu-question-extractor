package org.oksusubackend.service;

import org.oksusubackend.config.OpenAiConfig;
import org.oksusubackend.dto.GptRequest;
import org.oksusubackend.dto.GptResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GptService {

    private final OpenAiConfig openAiConfig;
    private final WebClient webClient;

    private static final String OPENAI_API_ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-3.5-turbo-1106";
    private static final String ROLE_SYSTEM = "system";
    private static final String ROLE_USER = "user";
    private static final String SYSTEM_MESSAGE = "You are a supervisor at the company. The input text is a company report, " +
            "so please extract three significant questions in Korean that you think are important regarding business strategy, growth opportunities, " +
            "risk factors, or operational improvements from this report." +
            "Example 1: 2023년도 제2분기 대비 제3분기 매출 성장률은 어떻게 변화하였으며, 이러한 변화의 주요 원인은 무엇인가요? 구체적인 수치를 바탕으로 설명해 주시기 바랍니다." +
            "Example 2: 최근 5년간 연구개발(R&D) 투자 대비 신제품 매출 비율을 분석해주실 수 있나요? 특히 2024년에 출시된 신제품의 R&D 투자 대비 매출 성과를 상세히 알려주세요" +
            "Example 3: 2025년까지의 재무 예측 모델에 따르면, 당사의 순이익률은 어떻게 변할 것으로 예상되나요? 이에 대한 예측을 수치적 근거와 함께 제시해 주시기 바랍니다." +
            "Example 4: 현재 진행 중인 해외 시장 확장 전략이 당사의 장기적인 재무 건전성에 미치는 영향을 수치적으로 어떻게 예측하고 계시나요? 특히, 신규 시장 진출로 인한 초기 투자 비용과 예상되는 매출 증대 효과를 구체적으로 분석해 주시기 바랍니다.";



    public GptService(OpenAiConfig openAiConfig) {
        this.openAiConfig = openAiConfig;
        this.webClient = WebClient.builder()
                .baseUrl(OPENAI_API_ENDPOINT)
                .defaultHeader("Authorization", "Bearer " + this.openAiConfig.getApiKey())
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<String> sendRequestToOpenAI(String text) {
        GptRequest.Message systemMessage = new GptRequest.Message(ROLE_SYSTEM, SYSTEM_MESSAGE);
        GptRequest.Message userMessage = new GptRequest.Message(ROLE_USER, text);

        GptRequest gptRequest = new GptRequest(MODEL, List.of(systemMessage, userMessage));

        return this.webClient.post()
                .bodyValue(gptRequest)
                .retrieve()
                .bodyToMono(GptResponse.class)
                .map(gptResponse -> gptResponse.getChoices().get(0).getMessage().getContent());
    }
}
