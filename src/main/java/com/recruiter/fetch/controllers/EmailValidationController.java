package com.recruiter.fetch.controllers;

import com.recruiter.fetch.services.EmailValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emails/validate")
public class EmailValidationController {

    @Autowired
    private EmailValidationService service;

    @PostMapping("")
    public ResponseEntity<Integer> countValidEmails(@RequestBody List<String> emails) {
        try {
            int count = service.countValidEmails(emails);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
        }
    }
}
