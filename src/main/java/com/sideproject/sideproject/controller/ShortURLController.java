package com.sideproject.sideproject.controller;

import com.sideproject.sideproject.dto.ShortUrlPasswordRequest;
import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.ShortURLService;
import com.sideproject.sideproject.util.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ShortURLController {

    @Autowired
    private ShortURLService shortURLService;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/shortUrls/{userId}")
    public ResponseEntity<List<ShortURL>> getAllShortURLs(@RequestHeader("user") String jwt, @PathVariable String userId){
        if (!tokenUtil.isTokenValid(userId, jwt)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<ShortURL> shortURLList = shortURLService.getAllShortURL(userId);

        return ResponseEntity.status(HttpStatus.OK).body(shortURLList);
    }

    @GetMapping("/users/{userId}/{shortUrl}")
    public ResponseEntity<ShortURL> getShortURL(@PathVariable Integer userId, @PathVariable String shortUrl) {
        ShortURL shortURL = shortURLService.getShortURLByUserId(userId, shortUrl);

        if (shortURL != null) {
            return ResponseEntity.ok(shortURL);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/users/{userId}/{shortUrl}/password")
    public ResponseEntity<ShortURL> getShortURLWithPassword(@PathVariable Integer userId, @PathVariable String shortUrl, @RequestBody @Valid ShortUrlPasswordRequest shortUrlPasswordRequest) {
        ShortURL shortURL = shortURLService.getShortURLByUserIdPassword(userId, shortUrl, shortUrlPasswordRequest.getPassword());
        if (shortURL != null) {
            return ResponseEntity.ok(shortURL);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/users/{userId}/shortUrl")
    public ResponseEntity<ShortURL> createShortURL(@RequestHeader(name = "user") String jwt, @PathVariable Integer userId, @RequestBody @Valid ShortUrlRequest shortUrlRequest) {
        if (!tokenUtil.isTokenValid(userId.toString(), jwt)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String shortUrlId = shortURLService.createShortURL(userId, shortUrlRequest);

        ShortURL shortURL = shortURLService.getShortURLByUserId(userId, shortUrlId);
        return ResponseEntity.status(HttpStatus.CREATED).body(shortURL);
    }
}
