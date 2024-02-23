package org.oksusubackend.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileContentExtractor {

    public static String extractContent(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            if (fileName != null && fileName.toLowerCase().endsWith(".pdf")) {
                return extractPdfContent(file.getInputStream());
            } else if (fileName != null && (fileName.toLowerCase().endsWith(".xlsx") || fileName.toLowerCase().endsWith(".xls"))) {
                return extractExcelContent(file.getInputStream());
            } else if (fileName != null && fileName.toLowerCase().endsWith(".txt")) {
                return extractTextContent(file.getInputStream());
            } else {
                return "Unsupported file type";
            }
        } catch (IOException e) {
            return "Error extracting file content: " + e.getMessage();
        }
    }

    private static String extractPdfContent(InputStream inputStream) throws IOException {
        try (PDDocument document = PDDocument.load(inputStream)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    private static String extractExcelContent(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        builder.append(cell.toString()).append("\t");
                    }
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

    private static String extractTextContent(InputStream inputStream) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                textBuilder.append(new String(buffer, 0, bytesRead));
            }
        }
        return textBuilder.toString();
    }
}
