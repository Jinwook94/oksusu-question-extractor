package org.oksusubackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.oksusubackend.service.FileAnalysisService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final FileAnalysisService fileAnalysisService;

    public FileUploadController(FileAnalysisService fileAnalysisService) {
        this.fileAnalysisService = fileAnalysisService;
    }

    @PostMapping("/upload")
    public Mono<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileAnalysisService.analyzeFileAndGenerateQuestions(file);
    }
}
