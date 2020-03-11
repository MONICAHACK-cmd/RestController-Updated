package com.hackathon.controller;

import com.hackathon.service.SendMailService;
import com.hackathon.util.RequestKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@ComponentScan("com")
public class SendMailController {

    @Autowired
    SendMailService mailService;

    @GetMapping("/test")
    String test() {
        return "Service is working fine !";
    }

    @PostMapping(value = RequestKeys.SENDMAIL)
    public String sendEmail(@RequestBody String jsonString) {
        try {
            return mailService.sendEmailToUser(jsonString);
        } catch (Exception e) {
            log.error("Caught Exception exception : "
                    + e);
            return String.valueOf(e);
        }
    }
}
