package com.example.controllers;

import com.example.entities.Book;
import com.example.services.JasperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class BookController {
    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping(value = "/books/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getBookPdfReport() {

        List<Book> sampleData = getBooks();

        byte[] pdfBytes = jasperReportService.generateBookReport(sampleData);

        HttpHeaders headers = getHttpHeaders();

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=book-report.pdf");
        return headers;
    }

    private static List<Book> getBooks() {
        List<Book> sampleData = List.of(
                new Book(1L, "Bible"),
                new Book(2L, "The Imitation of Christ")
        );
        return sampleData;
    }
}
