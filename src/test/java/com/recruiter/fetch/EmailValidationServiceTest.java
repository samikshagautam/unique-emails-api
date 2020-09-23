package com.recruiter.fetch;

import com.recruiter.fetch.services.EmailValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EmailValidationServiceTest {
    @Autowired
    EmailValidationService service;

    @Test
    void contextLoads() {
        List<String> emails = new ArrayList<>();
        emails.add("sami.gautam@gmail.com");
        emails.add("samigautam@gmail.com");
        emails.add("samigautam+ss@gmail.com");

        int count = service.countValidEmails(emails);
        assert (count == 1);

    }


}
