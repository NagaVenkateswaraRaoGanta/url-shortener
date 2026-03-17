package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Generate random short code
    public String generateShortCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            code.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return code.toString();
    }

    // Save URL and return short link
    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(shortCode);

        repository.save(mapping);

        return "http://localhost:8080/r/" + shortCode;
    }

    // Get original URL from short code
    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(UrlMapping::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}