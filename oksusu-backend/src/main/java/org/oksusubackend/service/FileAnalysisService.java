package org.oksusubackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.oksusubackend.util.FileContentExtractor;
import reactor.core.publisher.Mono;

@Service
public class FileAnalysisService {

    private final GptService gptService;

    public FileAnalysisService(GptService gptService) {
        this.gptService = gptService;
    }

    public Mono<String> analyzeFileAndGenerateQuestions(MultipartFile file) {
        String content = FileContentExtractor.extractContent(file);
        System.out.println(content);
        return gptService.sendRequestToOpenAI(content)
                .map(response -> "분석된 내용에 기반한 질문: " + response);
    }
}
