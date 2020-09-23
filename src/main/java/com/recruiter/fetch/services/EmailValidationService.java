package com.recruiter.fetch.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmailValidationService {
    public int countValidEmails(List<String> emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String userName = email.substring(0, atIndex).toLowerCase().replaceAll("\\.","");
            String domainName = email.substring(atIndex).toLowerCase();
            int plusIndex = userName.indexOf('+');
            if (plusIndex >= 0) {
                userName = userName.substring(0, plusIndex);
            }
            uniqueEmails.add(userName + domainName);
        }
        return uniqueEmails.size();
    }
}
