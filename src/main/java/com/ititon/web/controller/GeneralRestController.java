package com.ititon.web.controller;

import com.ititon.annotation.Loggable;
import com.ititon.dao.entity.Email;
import com.ititon.service_api.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralRestController {

    private EmailSenderService emailSenderService;


    @Autowired
    public GeneralRestController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }


    @PostMapping("/mail")
    @Loggable
    public ResponseEntity processMail(@RequestBody Email email) {
        if (email != null) {
            emailSenderService.send(email);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.noContent().build();
    }
}
