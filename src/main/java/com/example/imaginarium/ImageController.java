package com.example.imaginarium;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;


@RestController
public class ImageController {

    // reflecting the range from 1-100
    private static final int TOTAL_IMAGES = 100;
    private final Random random = new Random();

    @GetMapping("/images/random")
    public ResponseEntity<Resource> fetchRandomImage() throws IOException {
        int randomId = 1 + random.nextInt(TOTAL_IMAGES); // This will give a random number between 1 and 100 (inclusive)
        String imageName = "images/img (" + randomId + ").jpg";
        Resource imgFile = new ClassPathResource(imageName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imgFile);
    }
}
