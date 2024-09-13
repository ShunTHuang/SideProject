package com.sideproject.sideproject.controller;

import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.ShortURLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortURLController {

    @Autowired
    private ShortURLService shortURLService;

    @GetMapping("/shortUrls/{userId}")
    public ResponseEntity<List<ShortURL>> getAllShortURLs(@PathVariable String userId){
        List<ShortURL> shortURLList = shortURLService.getAllShortURL(userId);

        return ResponseEntity.status(HttpStatus.OK).body(shortURLList);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<ShortURL> getShortURL(@PathVariable String shortUrl) {
        ShortURL shortURL = shortURLService.getShortURL(shortUrl);

        if (shortURL != null) {
            return ResponseEntity.ok(shortURL);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/shortURL")
    public ResponseEntity<ShortURL> createShortURL(@RequestBody @Valid ShortUrlRequest shortUrlRequest) {
        String shortUrlId = shortURLService.createShortURL(shortUrlRequest);

        ShortURL shortURL = shortURLService.getShortURL(shortUrlId);
        return ResponseEntity.status(HttpStatus.CREATED).body(shortURL);
    }
}
