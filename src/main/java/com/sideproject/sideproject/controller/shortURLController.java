package com.sideproject.sideproject.controller;

import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.shortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class shortURLController {

    @Autowired
    private shortURLService shortURLService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<ShortURL> getShortURL(@PathVariable String shortUrl) {
        ShortURL shortURL = shortURLService.getShortURL(shortUrl);

        if (shortURL != null) {
            return ResponseEntity.ok(shortURL);
        }
        return ResponseEntity.status(404).build();
    }
}
