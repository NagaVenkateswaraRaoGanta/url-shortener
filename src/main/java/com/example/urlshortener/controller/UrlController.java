package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*") // ✅ ADD THIS LINE
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping("/shorten")
    public String shorten(@RequestParam String url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/r/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = service.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}